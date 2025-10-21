package org.example.app.ui.diagnostics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.example.app.R

/**
 * Developer-only diagnostics screen for permissions (not linked in UI).
 * Can be used in future for debugging runtime permission states.
 */
// PUBLIC_INTERFACE
class PermissionsDiagnosticsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_permissions_diagnostics, container, false)
}
