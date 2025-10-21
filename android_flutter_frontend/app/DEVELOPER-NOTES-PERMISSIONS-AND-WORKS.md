# Developer Notes: Permissions gating and WorkManager integration (Step 02 → Step 03)

This app centrally manages runtime permissions and will gate background work accordingly.

1) Permissions Manager
- Location, Media, and optional SMS permissions are grouped in PermissionsManager.
- Opt-ins (e.g., SMS) are persisted using SharedPreferences temporarily.
- Step 03: migrate opt-ins and requested flags to Jetpack DataStore with SharedPreferencesMigration.

2) Permissions Center UI
- The screen lists each permission group, their status, rationale, and an action to Request or open Settings if permanently denied.
- SMS includes an explicit opt-in toggle before requesting READ_SMS.

3) WorkManager stubs (future)
- MediaIndexWorker is a placeholder for local media analysis.
- WorkSchedulers.enqueueMediaIndexIfEligible(context) enqueues a one-time job with light constraints.
- Step 03+: Only enqueue work after verifying permissions via PermissionsManager.getStatus(PermissionGroup.MEDIA, activity).granted.

4) SDK-aware permissions
- Android 13+ (TIRAMISU): use READ_MEDIA_IMAGES
- Android 12 and below: READ_EXTERNAL_STORAGE (maxSdkVersion=32)
- Location: COARSE + FINE
- Optional SMS: READ_SMS (gated by explicit in-app opt-in)

5) Navigation
- Destinations and action IDs centralized in core/navigation/NavActions.kt (and NavIds.kt).

Build & Test:
- Project root: smart-personal-assistant-178449-178459/android_flutter_frontend
- Gradle wrapper: ./gradlew
- Example: ./gradlew :app:assembleDebug
