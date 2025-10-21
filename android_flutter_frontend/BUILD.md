# Build Instructions (Android Module Root)

This directory is the Android project root.
- settings.gradle.dcl (Declarative Gradle)
- Modules: :app, :list, :utilities

Build locally:
- ./gradlew build

Install debug:
- ./gradlew :app:installDebug

CI hint:
- If running from repository root, use the root `./gradlew` shim which delegates to this module path:
  smart-personal-assistant-178449-178459/android_flutter_frontend
