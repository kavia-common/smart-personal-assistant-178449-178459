package org.example.app.ui.diagnostics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.example.app.R
import org.example.app.core.permissions.PermissionsManager

/**
 * PUBLIC_INTERFACE
 * A lightweight, developer-facing diagnostics screen that prints current
 * permission statuses using PermissionsManager. Not linked in UI; can be
 * navigated to via tools or temporary actions while testing.
 */
class PermissionsDiagnosticsFragment : Fragment() {

    private lateinit var pm: PermissionsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pm = PermissionsManager(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_permissions_diagnostics, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Permissions Diagnostics"

        val loc = pm.getStatus(PermissionsManager.PermissionGroup.LOCATION, requireActivity())
        val med = pm.getStatus(PermissionsManager.PermissionGroup.MEDIA, requireActivity())
        val sms = pm.getStatus(PermissionsManager.PermissionGroup.SMS, requireActivity())

        fun text(s: PermissionsManager.PermissionStatus): String {
            return when {
                s.granted -> getString(R.string.status_granted)
                s.permanentlyDenied -> getString(R.string.status_denied_permanently)
                s.requestedBefore -> getString(R.string.status_denied)
                else -> getString(R.string.status_not_requested)
            }
        }

        view.findViewById<TextView>(R.id.diag_loc).text =
            getString(R.string.perm_location) + ": " + text(loc)
        view.findViewById<TextView>(R.id.diag_med).text =
            getString(R.string.perm_media) + ": " + text(med)
        view.findViewById<TextView>(R.id.diag_sms).text =
            getString(R.string.perm_sms) + ": " + text(sms)
    }
}
