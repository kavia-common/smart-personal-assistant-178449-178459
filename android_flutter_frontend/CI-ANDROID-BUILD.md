# CI Android Build Instructions

Android project root:
- smart-personal-assistant-178449-178459/android_flutter_frontend

Build from repository root using the shim:
- ./gradlew build

Or build from Android project root:
- cd smart-personal-assistant-178449-178459/android_flutter_frontend
- ./gradlew build

Notes:
- This project uses Gradle Declarative (.dcl) settings (settings.gradle.dcl).
- Modules: :app, :list, :utilities
- Main manifest: app/src/main/AndroidManifest.xml
