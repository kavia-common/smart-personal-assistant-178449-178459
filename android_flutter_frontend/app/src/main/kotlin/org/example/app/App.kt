package org.example.app

import android.app.Application
import androidx.work.Configuration

/**
 * Application class for initializing app-wide components.
 * Sets up WorkManager (stub configuration) and is the lifecycle entry point.
 */
// PUBLIC_INTERFACE
class App : Application(), Configuration.Provider {

    // Provide WorkManager configuration via property as required by Configuration.Provider
    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.INFO)
            .build()

    override fun onCreate() {
        super.onCreate()
        // Future: initialize DI, analytics, crash reporting, etc.
        // WorkManager initializes automatically using Configuration.Provider.
    }
}
