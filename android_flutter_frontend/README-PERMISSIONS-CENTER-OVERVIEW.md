# Permissions Center Overview (Step 02)

This document summarizes the permissions handling and UI added in Step 02.

Key components:
- Manifest permissions (SDK-aware):
  - Location: ACCESS_COARSE_LOCATION, ACCESS_FINE_LOCATION
  - Media: READ_MEDIA_IMAGES (API 33+), READ_EXTERNAL_STORAGE (API <= 32)
  - SMS (optional): READ_SMS (only requested after explicit user opt-in)
- Runtime manager: core/permissions/PermissionsManager.kt
  - Checks status, requests permissions, opens App Settings on permanent denial
  - Stores opt-ins and requested flags in SharedPreferences (DataStore migration in Step 03)
- Permissions Center UI:
  - ui/permissions/PermissionsCenterFragment.kt
  - Layout: res/layout/fragment_permissions_center.xml
  - Options menu: res/menu/permissions_center_menu.xml (Help)
  - Help screen: ui/permissions/PermissionsHelpFragment.kt and layout
- Diagnostics (dev-only): ui/diagnostics/PermissionsDiagnosticsFragment.kt
- Navigation: res/navigation/nav_graph.xml
  - Dashboard -> Permissions Center (action_dashboard_to_permissionsCenter)
  - Settings -> Permissions Center (action_settings_to_permissionsCenter)
  - Permissions Center -> Help

Testing shortcuts:
- Settings includes:
  - “Open Permissions Center”
  - “Open System Settings” (App Details)
  - “Learn more about permissions”
  - Inline permission statuses
- Dashboard has a permissions hint card; tapping navigates to Permissions Center.

Future (Step 03):
- Migrate SharedPreferences opt-ins to Jetpack DataStore.
- Integrate real WorkManager jobs with constraints (see core/work stubs).
