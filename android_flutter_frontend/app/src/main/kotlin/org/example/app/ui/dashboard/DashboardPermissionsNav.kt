package org.example.app.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import org.example.app.R

/**
 * PUBLIC_INTERFACE
 * DashboardPermissionsNav wires the "Permissions Center" entry to the nav graph.
 * Mixin-style helper to be used from DashboardFragment.onViewCreated.
 */
object DashboardPermissionsNav {

    // PUBLIC_INTERFACE
    fun attach(fragment: Fragment, rootView: View, savedInstanceState: Bundle?) {
        rootView.findViewById<MaterialButton?>(R.id.btn_open_permissions_center_from_dashboard)?.setOnClickListener {
            fragment.findNavController().navigate(R.id.action_dashboard_to_permissionsCenter)
        }
    }
}
