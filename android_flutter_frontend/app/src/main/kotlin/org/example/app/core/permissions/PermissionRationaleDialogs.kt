package org.example.app.core.permissions

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.example.app.R

/**
 * Lightweight helper to present rationale dialogs before requesting runtime permissions.
 * This is optional and can be invoked by UI before calling PermissionsManager.requestGroupPermissions.
 */
object PermissionRationaleDialogs {

    // PUBLIC_INTERFACE
    fun showRationale(
        context: Context,
        title: String,
        message: String,
        onProceed: () -> Unit,
        onCancel: (() -> Unit)? = null
    ) {
        /** Show a Material dialog with a rationale message; proceed triggers the system permission request. */
        MaterialAlertDialogBuilder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(R.string.action_request) { dialog, _ ->
                dialog.dismiss()
                onProceed()
            }
            .setNegativeButton(android.R.string.cancel) { dialog, _ ->
                dialog.dismiss()
                onCancel?.invoke()
            }
            .show()
    }
}
