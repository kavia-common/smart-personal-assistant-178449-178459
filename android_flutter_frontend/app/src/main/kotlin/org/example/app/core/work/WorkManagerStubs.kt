package org.example.app.core.work

import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneOffWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

/**
 * PUBLIC_INTERFACE
 * Provides stub methods to schedule background work with common constraints.
 * This will be wired to real workers in future steps (e.g., media analysis).
 */
object WorkManagerStubs {

    /**
     * Build a typical constraints object used for background analysis tasks.
     * - Requires device idle and charging when appropriate (to be tuned later)
     * - Requires unmetered network for any upload (if ever needed)
     */
    fun defaultAnalysisConstraints(): Constraints {
        return Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
    }

    /**
     * Schedule a placeholder one-off task using default constraints.
     * Currently not enqueued anywhere; call from future features.
     */
    fun schedulePlaceholderTask(context: Context, delayMinutes: Long = 15) {
        val constraints = defaultAnalysisConstraints()
        val request = OneOffWorkRequestBuilder<PlaceholderWorker>()
            .setConstraints(constraints)
            .setInitialDelay(delayMinutes, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(context).enqueue(request)
    }
}
