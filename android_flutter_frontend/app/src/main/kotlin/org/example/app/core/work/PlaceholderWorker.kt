package org.example.app.core.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

/**
 * PUBLIC_INTERFACE
 * Placeholder Worker used as a stub until concrete background tasks are implemented.
 */
class PlaceholderWorker(appContext: Context, params: WorkerParameters) : CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        // Simulate minimal background work; replace with real logic in later steps.
        delay(100)
        return Result.success()
    }
}
