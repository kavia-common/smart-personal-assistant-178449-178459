# App Module

This is the primary Android application module.

Highlights:
- Architecture: Fragments with Navigation Component; WorkManager (stubbed) for background tasks.
- Permissions (Step 02): Centralized `PermissionsManager`, in-app Permissions Center screen, SDK-aware permissions, SharedPreferences opt-ins (DataStore planned).
- Navigation: `res/navigation/nav_graph.xml` with destinations for Dashboard, Insights, Settings, Permissions Center.

Entry Points:
- MainActivity -> NavHostFragment -> BottomNavigation.
- Permissions Center accessible via BottomNavigation, Settings button, and Dashboard quick action.

Build:
- Use the wrapper at Android project root:
  `./android_flutter_frontend/gradlew -p android_flutter_frontend build`
