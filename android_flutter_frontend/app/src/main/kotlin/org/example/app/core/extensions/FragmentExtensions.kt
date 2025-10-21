package org.example.app.core.extensions

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.fragment.app.Fragment

/**
 * PUBLIC_INTERFACE
 * Fragment extension utilities.
 */
fun Fragment.openAppDetailsSettings() {
    /** Opens the system App Details screen for this application. */
    val intent = Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", requireContext().packageName, null)
    ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(intent)
}
