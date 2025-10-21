/*
 * NoOpWorker is a placeholder Worker for Step 02, compiling successfully while
 * we prepare real background work in Step 03.
 */
package org.example.app.core.work

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * A no-op Worker used as a placeholder until real background tasks are implemented in Step 03.
 * It immediately succeeds and performs no work.
 */
class NoOpWorker(appContext: Context, params: WorkerParameters) : Worker(appContext, params) {
    override fun doWork(): Result = Result.success()
}
