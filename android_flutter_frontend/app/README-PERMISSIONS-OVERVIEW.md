# Permissions Architecture Overview (Step 02)

Components:
- Manifest (SDK-aware):
  - Location: ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION
  - Media:
    - T+ (Android 13+): READ_MEDIA_IMAGES (and VIDEO if needed)
    - pre-33: READ_EXTERNAL_STORAGE (maxSdkVersion=32)
  - SMS (optional, behind explicit opt-in): READ_SMS
- Runtime:
  - PermissionsManager: centralizes checks, requests, opt-in persistence (SharedPreferences, migrate to DataStore in Step 03).
- UI:
  - PermissionsCenterFragment: shows statuses, rationales, request buttons, and links to system settings on permanent denial.
  - SettingsFragment: quick permission status summary + navigation to Permissions Center.
  - Dashboard: hint card linking users to Permissions Center (discoverability).
- Background work:
  - WorkScheduler + NoOpWorker: stubs for constraint-aware scheduling (to be implemented in Step 03).
- Navigation:
  - Bottom navigation entry for Permissions Center.
  - Settings action: action_settings_to_permissionsCenter.
  - Dashboard action: action_dashboard_to_permissionsCenter.
  - Deep link: app://org.example.app/permissions-center.

Notes:
- SMS is optional and should be requested only after explicit user opt-in.
- On permanent denial, redirect users to system settings via PermissionsManager.openAppSettings().

Build:
- Use the module's wrapper: ./android_flutter_frontend/gradlew :app:assembleDebug
