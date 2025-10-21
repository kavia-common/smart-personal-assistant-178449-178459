# core.permissions

Centralized runtime permissions handling.

- PermissionsManager: checks, requests, and persists opt-ins (temporary SharedPreferences; migrate to DataStore in Step 03).
- PermissionGroups: constants for logging/analytics and UI tagging.

Used by:
- UI: PermissionsCenterFragment
- Future: workers and services that need permission-aware behavior.
