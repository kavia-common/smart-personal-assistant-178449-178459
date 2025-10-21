package org.example.app.core.intents

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings

/**
 * PUBLIC_INTERFACE
 * IntentFactory centralizes creation of common system intents used across the app.
 */
object IntentFactory {

    // PUBLIC_INTERFACE
    fun appDetailsSettings(context: Context): Intent {
        /**
         * Returns an Intent to open the system "App info" settings page for this app.
         */
        return Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data = Uri.fromParts("package", context.packageName, null)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
    }
}
