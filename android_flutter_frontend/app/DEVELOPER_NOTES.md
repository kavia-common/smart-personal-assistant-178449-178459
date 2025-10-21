# Developer Notes: Project Root and Module Structure

This project uses Gradle 9 Declarative DSL (.dcl) with a multi-module structure:

- settings.gradle.dcl defines modules: `app` (Android application), `list`, and `utilities`.
- The Android app module root is: `android_flutter_frontend/app`.
- The applicationId is configured in `settings.gradle.dcl` defaults under `androidApplication`.

If a tool fails with "Could not determine project root directory", ensure it is launched from:
`smart-personal-assistant-178449-178459/android_flutter_frontend/`

Then typical commands:
- `./gradlew :app:assembleDebug`
- `./gradlew :app:installDebug`

This note is informational and has no effect on builds.
