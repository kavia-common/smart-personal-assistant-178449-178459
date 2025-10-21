package org.example.app.core.work

import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

/**
 * PUBLIC_INTERFACE
 * Provides constraint-aware scheduling stubs for background tasks.
 */
object WorkSchedulers {

    private const val MEDIA_ANALYSIS_UNIQUE = "media_analysis_periodic"

    /**
     * PUBLIC_INTERFACE
     * Enqueue a periodic media analysis worker with battery- and network-friendly constraints.
     * This is a no-op stub for now (worker does nothing significant until Step 03+).
     */
    fun scheduleMediaAnalysis(context: Context) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build()

        val request = PeriodicWorkRequestBuilder<MediaAnalysisWorker>(24, TimeUnit.HOURS)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            MEDIA_ANALYSIS_UNIQUE,
            ExistingPeriodicWorkPolicy.KEEP,
            request
        )
    }
}
