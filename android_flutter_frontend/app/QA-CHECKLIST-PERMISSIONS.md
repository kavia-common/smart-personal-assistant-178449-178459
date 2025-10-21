# QA Checklist - Step 02: Permissions

Preconditions:
- Fresh install recommended to validate first-run permission states.
- Device/emulator across API levels: 30-34.

Checks:
1) Navigation
   - Bottom nav includes "Permissions Center" and opens the screen.
   - Settings -> "Permissions Center" button navigates correctly.
   - Dashboard quick action opens "Permissions Center".

2) Location permissions
   - Initial state shows "Not requested".
   - Tap Manage -> system dialog appears; deny -> state changes to "Denied".
   - Deny + Don't ask again -> state shows "Denied (don't ask again)" and button label changes to "Open System Settings".
   - Grant -> shows "Granted".

3) Media permissions
   - API 33+: requests READ_MEDIA_IMAGES only; status updates similarly to Location.
   - API <33: requests READ_EXTERNAL_STORAGE; status updates similarly.

4) SMS (optional; consent-gated)
   - Toggle "Opt in" OFF: Request action does not prompt for permission.
   - Toggle "Opt in" ON: Request action can prompt; deny/grant flows update status.
   - On permanent denial, button reads "Open System Settings".

5) Accessibility
   - Headings announced for main titles.
   - Buttons and toggles have contentDescriptions.

6) Persistence
   - Opt-in toggle state persists across process restarts (SharedPreferences for now).

7) Regression
   - WorkManager initialization remains functional (Configuration.Provider).
   - App launches to Dashboard without crashes.

Notes:
- For CI/analyzers, use the wrapper under android_flutter_frontend:
  ./android_flutter_frontend/gradlew -p android_flutter_frontend build
