# Permissions: Step 02 Summary

This app implements a Permissions Center and a central PermissionsManager.

Key points:
- Manifest: Location (coarse/fine), Media (READ_MEDIA_IMAGES for T+; READ_EXTERNAL_STORAGE for <33), optional READ_SMS (behind explicit opt-in and Play policy compliance).
- Runtime: Activity Result APIs via PermissionsManager.buildRequestLauncher.
- Groups: LOCATION, MEDIA, SMS.
- Status: getStatus(...) returns granted, permanentlyDenied, requestedBefore.
- Opt-in: SMS is gated with user opt-in persisted via SharedPreferences (to be migrated to DataStore in Step 03).
- System settings: PermissionsManager.openAppSettings() deep-links to app details.

UI:
- Settings -> Permissions Center button (and also bottom navigation direct entry).
- PermissionsCenterFragment shows statuses, rationales, actions to request or open settings when permanently denied.
- Accessibility: content descriptions and headings are in place.

Navigation:
- nav_graph.xml includes permissionsCenterFragment.
- NavActions provides typed accessors for action IDs.

WorkManager (stub):
- App implements Configuration.Provider and disables default initializer per manifest.
- Future: After a permission is granted, schedule background work (constraint-aware) where needed.

Migration (Step 03):
- Replace SharedPreferences with Jetpack DataStore for opt-ins and permission request bookkeeping.

Build tips:
- Use wrapper under android_flutter_frontend: ./android_flutter_frontend/gradlew -p android_flutter_frontend build
