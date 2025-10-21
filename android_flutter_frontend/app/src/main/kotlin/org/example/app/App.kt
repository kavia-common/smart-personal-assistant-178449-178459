package org.example.app

import android.app.Application
import androidx.work.Configuration

/**
 * Application class for initializing app-wide components.
 * Sets up WorkManager (stub configuration) and is the lifecycle entry point.
 *
 * Note: Permissions-aware background work (e.g., media analysis) should be enqueued
 * after runtime grants using WorkScheduler (see core/work/WorkScheduler.kt).
 */
// PUBLIC_INTERFACE
class App : Application(), Configuration.Provider {

    // Provide WorkManager configuration via property as required by Configuration.Provider
    /**
     * PUBLIC_INTERFACE
     * Provides the WorkManager configuration for the application.
     * Sets a minimal logging level; future steps may add custom WorkerFactory.
     */
    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.INFO)
            .build()

    override fun onCreate() {
        super.onCreate()
        // Future: initialize DI, analytics, crash reporting, etc.
        // WorkManager initializes automatically using Configuration.Provider.
        // Step 03+: enqueue background work conditionally when permissions are granted
        // (e.g., media indexing when READ_MEDIA_IMAGES or READ_EXTERNAL_STORAGE is granted).
        // Example (pseudo):
        // if (PermissionsManager(this).getStatus(PermissionGroup.MEDIA, activity).granted) {
        //     WorkSchedulers.enqueueMediaIndexIfEligible(this)
        // }
    }
}
