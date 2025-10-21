# core.permissions

Centralized runtime permissions management for the app.

- PermissionsManager: SDK-aware permission mapping, status, request launcher, and opt-in persistence (SharedPreferences; migrate to DataStore in Step 03).
- Groups covered: Location, Media/Images (Android 13+), legacy storage (pre-33), optional SMS (behind explicit opt-in).
