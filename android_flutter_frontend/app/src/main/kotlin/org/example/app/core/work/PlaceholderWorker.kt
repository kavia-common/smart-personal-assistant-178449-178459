package org.example.app.core.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

/**
 * PUBLIC_INTERFACE
 * Placeholder worker that simulates minimal background work.
 * Replace with real media/message analysis tasks in future steps.
 */
class PlaceholderWorker(
    appContext: Context,
    params: WorkerParameters
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        // Simulate light work
        delay(100)
        return Result.success()
    }
}
