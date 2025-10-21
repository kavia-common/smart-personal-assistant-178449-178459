package org.example.app.core.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

/**
 * Placeholder worker for future media indexing and insights.
 * In Step 03+, enqueue this worker only when media permissions are granted.
 */
class MediaIndexWorker(
    appContext: Context,
    params: WorkerParameters
) : CoroutineWorker(appContext, params) {

    // PUBLIC_INTERFACE
    override suspend fun doWork(): Result {
        /** Stub background task: replace with actual indexing and analysis in later steps. */
        // No-op work; return success.
        return Result.success(workDataOf("status" to "noop"))
    }
}
