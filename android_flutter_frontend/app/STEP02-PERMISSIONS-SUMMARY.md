# Step 02: Permissions Handling & Permissions Center

Implemented:
- Manifest permissions (SDK-aware): Location, Media (T+ READ_MEDIA_IMAGES; pre-33 READ_EXTERNAL_STORAGE), optional SMS (requires explicit opt-in).
- PermissionsManager: runtime requests via Activity Result APIs, permission status checks, rationale handling helpers, SharedPreferences opt-in persistence (to be migrated to DataStore in Step 03).
- Permissions Center UI: statuses, actions, Open System Settings links on permanent denial, SMS opt-in toggle, rationale strings with SDK-aware copy, accessibility improvements, test-friendly IDs/tags.
- Navigation: Settings → Permissions Center action, deep link app://org.example.app/permissions-center handled in MainActivity (onCreate/onNewIntent).
- Work stubs: WorkScheduler enqueueMediaAnalysisIfPermitted called after media permission grant (prepping for Step 03 workers).

Next steps (Step 03+):
- Migrate opt-in storage from SharedPreferences to Jetpack DataStore.
- Implement workers for media analysis with appropriate constraints.
- Add automated tests for permission flows, deep links, and accessibility semantics.

Build:
- Use the Gradle wrapper in android_flutter_frontend: ./gradlew :app:assembleDebug
