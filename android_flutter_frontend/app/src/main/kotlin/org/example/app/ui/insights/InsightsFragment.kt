package org.example.app.ui.insights

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.example.app.R

/**
 * Insights screen to present model-driven insights to the user (placeholder).
 */
// PUBLIC_INTERFACE
class InsightsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_insights, container, false)
}
