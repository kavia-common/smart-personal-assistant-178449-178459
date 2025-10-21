package org.example.app.core.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

/**
 * PUBLIC_INTERFACE
 * Stub worker for future media analysis. No-op for now other than simulating light work.
 */
class MediaAnalysisWorker(
    appContext: Context,
    params: WorkerParameters
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        // TODO Step 03+: Implement real analysis and I/O with proper permissions checks
        delay(100) // simulate quick work
        return Result.success()
    }
}
