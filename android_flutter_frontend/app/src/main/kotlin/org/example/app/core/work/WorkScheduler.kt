package org.example.app.core.work

import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

/**
 * Central place to enqueue background work with common constraints.
 * Prepares stubs for future media analysis / insights jobs.
 */
object WorkScheduler {

    // PUBLIC_INTERFACE
    /**
     * Enqueue a media analysis task if permissions are granted.
     * Currently uses a NoOpWorker as a placeholder; will be replaced with
     * a concrete Worker in Step 03 with proper constraints and input data.
     *
     * @param context an application or activity context used to obtain WorkManager.
     */
    fun enqueueMediaAnalysisIfPermitted(context: Context) {
        /** Enqueue a media analysis worker with battery and storage-friendly constraints (stub). */
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
            .setRequiresBatteryNotLow(true)
            .build()

        // Placeholder - replace with a real Worker in Step 03
        val request = OneTimeWorkRequestBuilder<NoOpWorker>()
            .setConstraints(constraints)
            .build()

        // Note: This will be revisited in Step 03 with actual Worker class
        WorkManager.getInstance(context).enqueue(request)
    }
}
