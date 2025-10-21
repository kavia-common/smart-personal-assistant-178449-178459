package org.example.app.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.example.app.R

/**
 * Dashboard screen showing quick actions and contextual insights (placeholder).
 * PUBLIC_INTERFACE
 * Hosts onboarding hints and quick links (e.g., Permissions Center).
 */
// PUBLIC_INTERFACE
class DashboardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_dashboard, container, false)

    override fun onResume() {
        super.onResume()
        activity?.title = getString(R.string.title_dashboard)
    }

    /**
     * PUBLIC_INTERFACE
     * Wire dashboard hint card tap to navigate to Permissions Center for discoverability.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Navigate to Permissions Center when hint card is tapped (if present)
        view.findViewById<View?>(R.id.card_permissions_hint)?.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_permissionsCenter)
        }
    }
}
