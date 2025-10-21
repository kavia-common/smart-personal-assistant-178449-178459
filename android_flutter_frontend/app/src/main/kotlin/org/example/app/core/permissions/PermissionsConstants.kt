package org.example.app.core.permissions

/**
 * PUBLIC_INTERFACE
 * Shared constants for permissions, keys, and group labels.
 * Centralizing these helps maintain consistency across storage and UI layers.
 */
object PermissionsConstants {
    const val PREFS_NAME = "permissions_prefs"

    // Keys for opt-in and request flags
    fun keyRequested(group: String) = "perm_requested_$group"
    fun keyOptIn(group: String) = "perm_opt_in_$group"

    // Group names (should match PermissionsManager.PermissionGroup)
    const val GROUP_LOCATION = "LOCATION"
    const val GROUP_MEDIA = "MEDIA"
    const val GROUP_SMS = "SMS"
}
