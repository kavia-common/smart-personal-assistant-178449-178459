# Android Module Root

This folder is the Android project root for the app (uses Gradle Declarative .dcl).
- settings.gradle.dcl is here
- Gradle wrapper scripts are here
- Modules: :app, :list, :utilities

Build
- ./gradlew build

Step 02 Summary (Permissions)
- Manifest updated with SDK-aware location, media, and optional SMS permissions
- PermissionsManager: runtime checks, requests, rationale handling, user opt-in (SharedPreferences for now)
- Permissions Center UI: statuses, actions, system settings link
- Navigation: Settings -> Permissions Center; Dashboard hint; help screen
- WorkManager: constraint-aware stubs added

If tools need a root pointer, use this directory as the Android project root.
