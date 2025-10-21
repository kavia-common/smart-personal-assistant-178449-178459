package org.example.app.core.work

import android.content.Context
import androidx.work.*

/**
 * PUBLIC_INTERFACE
 * Provides common WorkManager constraints and a simple no-op worker stub that can
 * be used as a placeholder for future background processing (e.g., gallery analysis).
 */
object WorkConstraints {
    /** Network not required; device should be charging and not low on battery for heavy work. */
    val heavyWorkConstraints: Constraints = Constraints.Builder()
        .setRequiresCharging(true)
        .setRequiresBatteryNotLow(true)
        .build()

    /** Light work may proceed without charging, but avoid low battery. */
    val lightWorkConstraints: Constraints = Constraints.Builder()
        .setRequiresBatteryNotLow(true)
        .build()
}

/**
 * A placeholder no-op worker to validate WorkManager wiring.
 * Replace with actual workers in later steps.
 */
class NoopWorker(appContext: Context, params: WorkerParameters) : CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        // No-op work. Used for scheduling validation.
        return Result.success()
    }

    companion object {
        // PUBLIC_INTERFACE
        fun oneTimeRequestLight(): OneTimeWorkRequest {
            /** Create a one-time light work request using standard constraints. */
            return OneTimeWorkRequestBuilder<NoopWorker>()
                .setConstraints(WorkConstraints.lightWorkConstraints)
                .build()
        }

        // PUBLIC_INTERFACE
        fun oneTimeRequestHeavy(): OneTimeWorkRequest {
            /** Create a one-time heavy work request using standard constraints. */
            return OneTimeWorkRequestBuilder<NoopWorker>()
                .setConstraints(WorkConstraints.heavyWorkConstraints)
                .build()
        }
    }
}
