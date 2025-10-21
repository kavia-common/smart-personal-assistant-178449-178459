/*
 * Runtime permissions manager for Smart Personal Assistant.
 * Handles SDK-aware permission mapping and user opt-in persistence.
 */
package org.example.app.core.permissions

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.MainThread
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

/**
 * Central manager for runtime permission checks and requests.
 * Handles SDK-aware permission mapping (e.g., Android 13+ media permissions)
 * and persists user opt-in choices (temporary using SharedPreferences).
 */
// PUBLIC_INTERFACE
class PermissionsManager(private val context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    enum class PermissionGroup {
        LOCATION,
        MEDIA,
        SMS
    }

    data class PermissionStatus(
        val granted: Boolean,
        val permanentlyDenied: Boolean,
        val requestedBefore: Boolean
    )

    // PUBLIC_INTERFACE
    fun setUserOptIn(group: PermissionGroup, optedIn: Boolean) {
        /**
         * Persist user's explicit opt-in choice for optional permissions (e.g., SMS).
         * Temporary persistence uses SharedPreferences and will be migrated to DataStore in Step 03.
         *
         * @param group The permission group for which the opt-in is being set.
         * @param optedIn Whether the user has opted in to this optional permission flow.
         */
        prefs.edit().putBoolean(keyUserOptIn(group), optedIn).apply()
    }

    // PUBLIC_INTERFACE
    fun isUserOptedIn(group: PermissionGroup): Boolean {
        /**
         * Returns the user's explicit opt-in choice for an optional permission.
         * Defaults to false if never set.
         *
         * @param group The permission group.
         * @return true if user opted in; false otherwise.
         */
        return prefs.getBoolean(keyUserOptIn(group), false)
    }

    // PUBLIC_INTERFACE
    fun getStatus(group: PermissionGroup, activity: Activity): PermissionStatus {
        /**
         * Returns the current permission state for a group.
         *
         * granted: true if all permissions in the group are granted.
         * permanentlyDenied: true if denied and the system would not show a rationale (i.e., user selected "don't ask again").
         * requestedBefore: indicates whether this group has ever been requested from within the app.
         *
         * @param group The permission group to check.
         * @param activity The host Activity, used to determine rationale visibility.
         */
        val permissions = permissionsForGroup(group)
        val allGranted = permissions.all { isPermissionGranted(it) }
        val requestedBefore = prefs.getBoolean(keyRequested(group), false)

        var permanentlyDenied = false
        if (!allGranted && requestedBefore) {
            // If any permission is denied AND system would not show rationale -> likely "Don't ask again"
            permanentlyDenied = permissions.any { perm ->
                !shouldShowRationale(activity, perm)
                        && ContextCompat.checkSelfPermission(context, perm) == PackageManager.PERMISSION_DENIED
            }
        }
        return PermissionStatus(allGranted, permanentlyDenied, requestedBefore)
    }

    // PUBLIC_INTERFACE
    fun openAppSettings() {
        /**
         * Launches the system App Info screen for this app package so the user can manually
         * grant or revoke permissions when they have selected "Don't ask again".
         */
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data = Uri.fromParts("package", context.packageName, null)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }

    /**
     * PUBLIC_INTERFACE
     * Build an Activity Result API launcher for requesting multiple permissions.
     * Returns true if all requested permissions are granted.
     *
     * @param caller ActivityResultCaller (Fragment or Activity) to register the launcher.
     * @param onResult callback invoked with true when all requested permissions are granted.
     */
    @MainThread
    fun buildRequestLauncher(
        caller: ActivityResultCaller,
        onResult: (Boolean) -> Unit
    ): androidx.activity.result.ActivityResultLauncher<Array<String>> {
        return caller.registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { result ->
            val granted = result.values.all { it }
            onResult(granted)
        }
    }

    // PUBLIC_INTERFACE
    /**
     * Request the appropriate permission set for a group, saving the 'requested' flag for rationale logic.
     *
     * @param group PermissionGroup to request (LOCATION, MEDIA, SMS).
     * @param launcher ActivityResultLauncher previously created by buildRequestLauncher.
     */
    fun requestGroupPermissions(
        group: PermissionGroup,
        launcher: androidx.activity.result.ActivityResultLauncher<Array<String>>
    ) {
        val permissions = permissionsForGroup(group)
        prefs.edit().putBoolean(keyRequested(group), true).apply()
        launcher.launch(permissions.toTypedArray())
    }

    private fun isPermissionGranted(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
    }

    private fun shouldShowRationale(activity: Activity, permission: String): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)
    }

    private fun permissionsForGroup(group: PermissionGroup): List<String> {
        return when (group) {
            PermissionGroup.LOCATION -> listOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            PermissionGroup.MEDIA -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    listOf(
                        Manifest.permission.READ_MEDIA_IMAGES
                        // Extend to READ_MEDIA_VIDEO if video analysis is needed
                    )
                } else {
                    listOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                }
            }
            PermissionGroup.SMS -> listOf(Manifest.permission.READ_SMS)
        }
    }

    private fun keyRequested(group: PermissionGroup) = "perm_requested_${group.name}"
    private fun keyUserOptIn(group: PermissionGroup) = "perm_opt_in_${group.name}"

    // PUBLIC_INTERFACE
    /**
     * Returns true if any critical permissions (Location or Media) are currently not granted.
     * Useful for gating features or showing hints (e.g., on Dashboard).
     */
    fun isAnyCriticalPermissionMissing(activity: Activity): Boolean {
        val loc = getStatus(PermissionGroup.LOCATION, activity).granted
        val med = getStatus(PermissionGroup.MEDIA, activity).granted
        return !loc || !med
    }

    /**
     * Determine if any core permission (Location or Media) is currently missing.
     * Useful for onboarding hints.
     */
    // PUBLIC_INTERFACE
    fun isAnyCriticalPermissionMissing(activity: Activity): Boolean {
        val loc = getStatus(PermissionGroup.LOCATION, activity)
        val media = getStatus(PermissionGroup.MEDIA, activity)
        return !loc.granted || !media.granted
    }

    companion object {
        private const val PREFS_NAME = "permissions_prefs"
    }
}
