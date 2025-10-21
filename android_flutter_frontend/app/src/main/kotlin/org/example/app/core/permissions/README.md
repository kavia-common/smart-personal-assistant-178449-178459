# Permissions Architecture (Step 02)

Components
- PermissionsManager.kt
  - PUBLIC_INTERFACE APIs:
    - setUserOptIn(group, optedIn)
    - isUserOptedIn(group)
    - getStatus(group, activity)
    - openAppSettings()
    - buildRequestLauncher(caller, onResult)
    - requestGroupPermissions(group, launcher)
    - isAnyCriticalPermissionMissing(activity)
- Groups: LOCATION, MEDIA, SMS (optional)
- SDK-aware media permissions (T+ READ_MEDIA_IMAGES vs <33 READ_EXTERNAL_STORAGE)

Persistence
- Temporary SharedPreferences for opt-ins; migrate to DataStore in Step 03.

UI
- PermissionsCenterFragment: centralized status and actions
- PermissionsHelpFragment: quick guidance
- Settings: links to Center/Help + summaries
- Dashboard: hint card to Center

Notes
- On permanent denial, we deep link to system settings (App Info) via openAppSettings().
- WorkManager stubs added for future constraint-aware background tasks.
