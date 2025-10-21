# Permissions Summary (SDK-aware)

Location:
- ACCESS_COARSE_LOCATION
- ACCESS_FINE_LOCATION

Media & Gallery:
- Android 13+ (API 33+): READ_MEDIA_IMAGES
- Android 12 and below: READ_EXTERNAL_STORAGE (maxSdkVersion=32)

SMS (Optional):
- READ_SMS (gated by explicit in-app opt-in and Play policy compliance)

Runtime handling:
- Centralized in `PermissionsManager`
- UI: `PermissionsCenterFragment`
- Persistence: SharedPreferences (temporary; migrate to DataStore in Step 03)

Navigation:
- Open via Settings button or Dashboard quick action
- Destination ID: `@id/permissionsCenterFragment`
