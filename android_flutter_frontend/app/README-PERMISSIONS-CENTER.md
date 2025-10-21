# Permissions Center

Overview
- Central hub to view and manage app permissions (Location, Media/Gallery, optional SMS).
- Optional SMS is disabled by default and requires explicit in-app user opt-in.

Runtime flows
- Uses Activity Result APIs (RequestMultiplePermissions).
- SDK-aware media permissions:
  - Android 13+ (TIRAMISU): READ_MEDIA_IMAGES
  - Android 12 and below: READ_EXTERNAL_STORAGE
- Location: ACCESS_FINE_LOCATION + ACCESS_COARSE_LOCATION
- SMS (optional): READ_SMS (requires explicit user opt-in)

UX behaviors
- If a permission is permanently denied, “Open System Settings” appears.
- SMS has an in-app “Opt in” switch (SharedPreferences for Step 02; migrate to DataStore in Step 03).
- Deep link for QA: app://org.example.app/permissions-center (handled in MainActivity onCreate/onNewIntent)

Testing tips
- Navigate from Settings > Permissions Center.
- Try toggling SMS opt-in and requesting permissions.
- Deny with “Don’t ask again” then use Open System Settings.
- Use adb: adb shell am start -a android.intent.action.VIEW -d "app://org.example.app/permissions-center"
