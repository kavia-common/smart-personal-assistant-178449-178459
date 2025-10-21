package org.example.app.ui.settings

/*
 * SettingsFragment: shows app settings and a summarized view of permission statuses,
 * with navigation to the Permissions Center and Help screens.
 */

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import org.example.app.R
import org.example.app.core.permissions.PermissionsManager

/**
 * Settings screen for configuring the application. Provides a quick
 * summary of permission statuses and links to the Permissions Center and Help.
 */
// PUBLIC_INTERFACE
class SettingsFragment : Fragment() {

    private lateinit var permissionsManager: PermissionsManager
    private var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_settings, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rootView = view

        permissionsManager = PermissionsManager(requireContext())

        // Navigate to Permissions Center (button)
        view.findViewById<MaterialButton?>(R.id.btn_open_permissions_center)?.setOnClickListener {
            findNavController().navigate(R.id.action_settings_to_permissionsCenter)
        }
        // Navigate to Permissions Center (row include)
        view.findViewById<View?>(R.id.row_permissions_center)?.setOnClickListener {
            findNavController().navigate(R.id.action_settings_to_permissionsCenter)
        }
        // Navigate to Permissions Help (optional; guarded in case destination is not present)
        view.findViewById<MaterialButton?>(R.id.btn_open_permissions_help)?.setOnClickListener {
            val nav = findNavController()
            val destId = resources.getIdentifier("permissionsHelpFragment", "id", requireContext().packageName)
            if (destId != 0) {
                nav.navigate(destId)
            }
        }
        // Open system settings for the app (permissions management)
        view.findViewById<MaterialButton?>(R.id.btn_open_system_settings)?.setOnClickListener {
            permissionsManager.openAppSettings()
        }

        // Initial bind of permission statuses
        bindPermissionStatuses(view)
    }

    override fun onResume() {
        super.onResume()
        activity?.title = getString(R.string.title_settings)
        // Refresh statuses when returning from system settings or other screens
        rootView?.let { bindPermissionStatuses(it) }
    }

    private fun bindPermissionStatuses(root: View) {
        val loc = permissionsManager.getStatus(PermissionsManager.PermissionGroup.LOCATION, requireActivity())
        val med = permissionsManager.getStatus(PermissionsManager.PermissionGroup.MEDIA, requireActivity())
        val sms = permissionsManager.getStatus(PermissionsManager.PermissionGroup.SMS, requireActivity())

        root.findViewById<TextView?>(R.id.perm_status_location)?.text =
            getString(R.string.label_permission_status, statusText(loc))
        root.findViewById<TextView?>(R.id.perm_status_media)?.text =
            getString(R.string.label_permission_status, statusText(med))
        root.findViewById<TextView?>(R.id.perm_status_sms)?.text =
            getString(R.string.label_permission_status, statusText(sms))
    }

    private fun statusText(status: PermissionsManager.PermissionStatus): String {
        return when {
            status.granted -> getString(R.string.status_granted)
            status.permanentlyDenied -> getString(R.string.status_denied_permanently)
            status.requestedBefore -> getString(R.string.status_denied)
            else -> getString(R.string.status_not_requested)
        }
    }
}
