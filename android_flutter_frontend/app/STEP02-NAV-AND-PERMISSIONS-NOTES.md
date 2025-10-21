# Step 02: Navigation and Permissions Notes

- Bottom navigation contains a direct item to the Permissions Center (id: permissionsCenterFragment).
- Navigation graph includes the destination `org.example.app.ui.permissions.PermissionsCenterFragment`.
- Settings screen also links to the Permissions Center via action `action_settings_to_permissionsCenter`.
- Permissions are requested using Activity Result APIs with SDK-aware handling:
  - Android 13+ uses READ_MEDIA_IMAGES
  - Android 12 and below uses READ_EXTERNAL_STORAGE
  - Location uses FINE/COARSE
  - SMS is optional and requires explicit user opt-in.
- On permanent denial, users are directed to system App Settings.

Build:
- Use the module wrapper: ./android_flutter_frontend/gradlew :app:assembleDebug
