package org.example.app

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * MainActivity hosts the Navigation Component and a BottomNavigationView
 * to switch between Dashboard, Insights, and Settings screens.
 * This sets up the base for MVVM by delegating UI to fragments.
 */
// PUBLIC_INTERFACE
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up Navigation with BottomNavigationView
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        NavigationUI.setupWithNavController(bottomNav, navController)

        // Ensure initial app bar title is set to the start destination
        title = getString(R.string.title_dashboard)

        // Optional: allow QA to navigate to Permissions Center if menu item is enabled/shown
        var lastNavTime = 0L
        bottomNav.setOnItemSelectedListener { item ->
            val now = System.currentTimeMillis()
            // Simple debounce: ignore selections within 300ms
            if (now - lastNavTime < 300) return@setOnItemSelectedListener true
            lastNavTime = now

            when (item.itemId) {
                R.id.dashboardFragment -> {
                    if (navController.currentDestination?.id != R.id.dashboardFragment) {
                        navController.navigate(R.id.dashboardFragment)
                    }
                    true
                }
                R.id.insightsFragment -> {
                    if (navController.currentDestination?.id != R.id.insightsFragment) {
                        navController.navigate(R.id.insightsFragment)
                    }
                    true
                }
                R.id.settingsFragment -> {
                    if (navController.currentDestination?.id != R.id.settingsFragment) {
                        navController.navigate(R.id.settingsFragment)
                    }
                    true
                }
                R.id.permissionsCenterFragment -> {
                    if (navController.currentDestination?.id != R.id.permissionsCenterFragment) {
                        navController.navigate(R.id.permissionsCenterFragment)
                    }
                    true
                }
                else -> false
            }
        }

        // Handle deep links (e.g., app://org.example.app/permissions-center)
        intent?.data?.let { data: Uri ->
            val isPermissionsCenter = (data.scheme == "app"
                    && data.host == "org.example.app"
                    && data.path == "/permissions-center")
            if (isPermissionsCenter) {
                // Navigate to Permissions Center destination if not already there
                val currentDestId = navController.currentDestination?.id
                if (currentDestId != R.id.permissionsCenterFragment) {
                    navController.navigate(R.id.permissionsCenterFragment)
                    override fun onNewIntent(intent: android.content.Intent?) {
        super.onNewIntent(intent)
        if (intent?.data != null) {
            setIntent(intent)
            // Reuse existing deep link handling path in onCreate-equivalent logic
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as androidx.navigation.fragment.NavHostFragment
            val navController = navHostFragment.navController

            intent.data?.let { data ->
                val isPermissionsCenter = (data.scheme == "app"
                        && data.host == "org.example.app"
                        && data.path == "/permissions-center")
                if (isPermissionsCenter) {
                    val currentDestId = navController.currentDestination?.id
                    if (currentDestId != R.id.permissionsCenterFragment) {
                        navController.navigate(R.id.permissionsCenterFragment)
                    }
                    // Clear to avoid re-navigation loops
                    intent.data = null
                }
            }
        }
    }
}
                // Clear data so we don't navigate again on configuration change
                intent.data = null
            }
        }
    }
}
