# Maintainers: Permissions Components Overview

Code locations:
- Manager (runtime checks/requests, opt-ins):
  app/src/main/kotlin/org/example/app/core/permissions/PermissionsManager.kt
- UI (Permissions Center screen):
  app/src/main/kotlin/org/example/app/ui/permissions/PermissionsCenterFragment.kt
- Layout:
  app/src/main/res/layout/fragment_permissions_center.xml
- Nav graph:
  app/src/main/res/navigation/nav_graph.xml
- Strings:
  app/src/main/res/values/strings.xml
- WorkManager stubs (future scheduling post-permission):
  app/src/main/kotlin/org/example/app/core/work/

Manifest:
  app/src/main/AndroidManifest.xml

Entry points:
- Settings screen button (fragment_settings.xml -> SettingsFragment)
- Dashboard quick action (fragment_dashboard.xml -> DashboardFragment)

Temporary persistence:
- SharedPreferences (to be migrated to DataStore in Step 03)
