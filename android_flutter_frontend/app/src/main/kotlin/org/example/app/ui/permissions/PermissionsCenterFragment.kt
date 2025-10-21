package org.example.app.ui.permissions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import org.example.app.R
import org.example.app.core.permissions.PermissionsManager

/**
 * PUBLIC_INTERFACE
 * Permissions Center screen lists current permission states with actions to request
 * or open system settings when permanently denied. Also includes optional SMS opt-in switch.
 * Exposes actionable UI for Location, Media, and optional SMS permissions.
 */
class PermissionsCenterFragment : Fragment() {

    private lateinit var permissionsManager: PermissionsManager
    private lateinit var requestLauncher: androidx.activity.result.ActivityResultLauncher<Array<String>>

    private lateinit var locationStatus: TextView
    private lateinit var locationAction: MaterialButton

    private lateinit var mediaStatus: TextView
    private lateinit var mediaAction: MaterialButton

    private lateinit var smsStatus: TextView
    private lateinit var smsAction: MaterialButton
    private lateinit var smsOptIn: Switch
    private lateinit var smsRationale: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_permissions_center, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = getString(R.string.title_permissions_center)

        permissionsManager = PermissionsManager(requireContext())
        requestLauncher = permissionsManager.buildRequestLauncher(this) {
            // Refresh UI after any permission request result
            bindStates()
        }

        // Bind views
        locationStatus = view.findViewById(R.id.location_status)
        locationAction = view.findViewById(R.id.location_action)

        mediaStatus = view.findViewById(R.id.media_status)
        mediaAction = view.findViewById(R.id.media_action)
        // Update media rationale text dynamically based on SDK version
        view.findViewById<TextView?>(R.id.media_rationale)?.text =
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                getString(R.string.rationale_media_t)
            } else {
                getString(R.string.rationale_media_pre_t)
            }

        smsStatus = view.findViewById(R.id.sms_status)
        smsAction = view.findViewById(R.id.sms_action)
        smsOptIn = view.findViewById(R.id.sms_opt_in)
        smsRationale = view.findViewById(R.id.sms_rationale)

        setupActions()
        bindStates()
    }

    private fun setupActions() {
        locationAction.setOnClickListener {
            val status = permissionsManager.getStatus(PermissionsManager.PermissionGroup.LOCATION, requireActivity())
            if (status.permanentlyDenied) {
                permissionsManager.openAppSettings()
            } else {
                permissionsManager.requestGroupPermissions(PermissionsManager.PermissionGroup.LOCATION, requestLauncher)
            }
        }
        mediaAction.setOnClickListener {
            val status = permissionsManager.getStatus(PermissionsManager.PermissionGroup.MEDIA, requireActivity())
            if (status.permanentlyDenied) {
                permissionsManager.openAppSettings()
            } else {
                permissionsManager.requestGroupPermissions(PermissionsManager.PermissionGroup.MEDIA, requestLauncher)
            }
        }
        smsAction.setOnClickListener {
            val optedIn = permissionsManager.isUserOptedIn(PermissionsManager.PermissionGroup.SMS)
            if (!optedIn) {
                // Require explicit opt-in before requesting
                smsOptIn.isChecked = true
                permissionsManager.setUserOptIn(PermissionsManager.PermissionGroup.SMS, true)
            }
            val status = permissionsManager.getStatus(PermissionsManager.PermissionGroup.SMS, requireActivity())
            if (status.permanentlyDenied) {
                permissionsManager.openAppSettings()
            } else if (permissionsManager.isUserOptedIn(PermissionsManager.PermissionGroup.SMS)) {
                permissionsManager.requestGroupPermissions(PermissionsManager.PermissionGroup.SMS, requestLauncher)
            }
        }

        smsOptIn.setOnCheckedChangeListener { _, isChecked ->
            permissionsManager.setUserOptIn(PermissionsManager.PermissionGroup.SMS, isChecked)
            bindStates()
        }
    }

    private fun bindStates() {
        // Location
        run {
            val status = permissionsManager.getStatus(PermissionsManager.PermissionGroup.LOCATION, requireActivity())
            locationStatus.text = getString(
                R.string.label_permission_status,
                when {
                    status.granted -> getString(R.string.status_granted)
                    status.permanentlyDenied -> getString(R.string.status_denied_permanently)
                    status.requestedBefore -> getString(R.string.status_denied)
                    else -> getString(R.string.status_not_requested)
                }
            )
            locationAction.text = if (status.permanentlyDenied) {
                getString(R.string.action_open_settings)
            } else {
                getString(R.string.action_request)
            }
        }

        // Media
        run {
            val status = permissionsManager.getStatus(PermissionsManager.PermissionGroup.MEDIA, requireActivity())
            mediaStatus.text = getString(
                R.string.label_permission_status,
                when {
                    status.granted -> getString(R.string.status_granted)
                    status.permanentlyDenied -> getString(R.string.status_denied_permanently)
                    status.requestedBefore -> getString(R.string.status_denied)
                    else -> getString(R.string.status_not_requested)
                }
            )
            mediaAction.text = if (status.permanentlyDenied) {
                getString(R.string.action_open_settings)
            } else {
                getString(R.string.action_request)
            }
            // Update rationale text based on SDK for clarity
            view?.findViewById<TextView?>(R.id.media_rationale)?.text =
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                    getString(R.string.rationale_media_t)
                } else {
                    getString(R.string.rationale_media_pre_t)
                }
        }

        // SMS
        run {
            val status = permissionsManager.getStatus(PermissionsManager.PermissionGroup.SMS, requireActivity())
            smsStatus.text = getString(
                R.string.label_permission_status,
                when {
                    status.granted -> getString(R.string.status_granted)
                    status.permanentlyDenied -> getString(R.string.status_denied_permanently)
                    status.requestedBefore -> getString(R.string.status_denied)
                    else -> getString(R.string.status_not_requested)
                }
            )
            smsAction.text = if (status.permanentlyDenied) {
                getString(R.string.action_open_settings)
            } else {
                getString(R.string.action_request)
            }
            smsOptIn.isChecked = permissionsManager.isUserOptedIn(PermissionsManager.PermissionGroup.SMS)

            // Show appropriate rationale
            smsRationale.text = getString(R.string.rationale_sms_optional)
        }
    }
}
