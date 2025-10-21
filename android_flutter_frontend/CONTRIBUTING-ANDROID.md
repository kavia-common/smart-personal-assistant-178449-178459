# Contributing: Android Module Path

Android project location:
- smart-personal-assistant-178449-178459/android_flutter_frontend

Build commands:
- cd smart-personal-assistant-178449-178459/android_flutter_frontend
- ./gradlew build
- ./gradlew :app:installDebug

Notes:
- Uses Gradle Declarative (.dcl) settings.
- Modules: :app, :list, :utilities.
- If invoking from repo root, use the provided root `./gradlew` shim which delegates to the Android project.
