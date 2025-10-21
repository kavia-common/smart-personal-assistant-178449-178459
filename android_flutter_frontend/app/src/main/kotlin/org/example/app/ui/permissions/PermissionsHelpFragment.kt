package org.example.app.ui.permissions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.example.app.R

/**
 * A simple help screen explaining why permissions are requested and how they are used.
 * Links back from nav_graph via action_permissionsHelp_to_permissionsCenter.
 */
// PUBLIC_INTERFACE
class PermissionsHelpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_permissions_help, container, false)
}
