# Step 02: Permissions Handling and Permissions Center

This module implements:
- Manifest permissions for location, media (SDK-aware: READ_MEDIA_IMAGES on T+, READ_EXTERNAL_STORAGE pre-33), and optional SMS (explicit opt-in).
- PermissionsManager: centralized runtime permission checks/requests, with SharedPreferences to persist opt-ins and requested flags (to migrate to DataStore in Step 03).
- Permissions Center UI (PermissionsCenterFragment): shows statuses, rationales, actions (Request/Open Settings).
- Links to system settings when permanently denied.
- WorkManager stubs for constraint-aware scheduling (no-op worker).

Key files:
- Manifest: app/src/main/AndroidManifest.xml
- Manager: app/src/main/kotlin/org/example/app/core/permissions/PermissionsManager.kt
- UI: app/src/main/kotlin/org/example/app/ui/permissions/PermissionsCenterFragment.kt
- Layout: app/src/main/res/layout/fragment_permissions_center.xml
- Strings: app/src/main/res/values/strings.xml
- Nav graph: app/src/main/res/navigation/nav_graph.xml
- Optional SMS opt-in persists via SharedPreferences.

Testing steps (manual):
1) Launch app -> Dashboard.
2) Use Dashboard hint card “Permissions Center” or Settings -> Permissions Center button.
3) Request Location, Media; on deny with “Don’t ask again,” Open Settings button appears.
4) Toggle SMS opt-in; only when opted-in will Request ask for READ_SMS.

Notes:
- For Android 13+ (API 33+), only READ_MEDIA_IMAGES is requested (not video).
- For API 30–32, READ_EXTERNAL_STORAGE is requested.
- DataStore migration planned in Step 03.

Troubleshooting:
- If nav to Permissions Center fails, ensure nav_graph.xml includes destination `permissionsCenterFragment`.
- If analyzer can’t detect project root, start Gradle from android_flutter_frontend:
  cd android_flutter_frontend && ./gradlew build
