# Permissions Center Usage & Policy Notes

Purpose
- Central hub for requesting and reviewing permissions: Location, Media (SDK-aware), and optional SMS (explicit opt-in required).

Key UX
- Shows current status (Granted / Denied / Denied permanently / Not requested).
- Request invokes runtime permission dialogs using Activity Result APIs.
- If Denied permanently, provides a button to open system App Settings.
- SMS requires in-app opt-in toggle before any request is made.

SDK-aware Media
- Android 13+ uses READ_MEDIA_IMAGES (granular, no full storage access).
- Android 12 and below use READ_EXTERNAL_STORAGE (maxSdkVersion=32).
- Rationale text in UI updates dynamically per SDK level.

Persistence
- Opt-ins persist temporarily via SharedPreferences.
- Step 03: migrate opt-ins to DataStore.

Navigation
- Settings -> Permissions Center (and Help).
- Dashboard hint -> Permissions Center.
- Help screen explains how to manage and recover from permanently denied states.

Policy note
- SMS analysis is optional. Ensure Play policy compliance for releases. Consider alternatives like Notification Listener/SMS Retriever where applicable.
