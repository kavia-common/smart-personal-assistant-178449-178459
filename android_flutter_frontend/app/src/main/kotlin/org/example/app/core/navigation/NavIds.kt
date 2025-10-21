package org.example.app.core.navigation

import org.example.app.R

/**
 * PUBLIC_INTERFACE
 * Centralized navigation destination/action IDs used across the app.
 * This provides a canonical place for tooling and maintainers to reference IDs.
 */
object NavIds {
    /** Destination IDs */
    const val DASHBOARD = R.id.dashboardFragment
    const val INSIGHTS = R.id.insightsFragment
    const val SETTINGS = R.id.settingsFragment
    const val PERMISSIONS_CENTER = R.id.permissionsCenterFragment

    /** Action IDs */
    const val ACTION_SETTINGS_TO_PERMISSIONS = R.id.action_settings_to_permissionsCenter
}
