# Android Project Location

The Android project uses Gradle 9 Declarative DSL (.dcl) and lives under:

- android_flutter_frontend/

Use the Gradle wrapper there:

- ./android_flutter_frontend/gradlew :app:assembleDebug
- ./android_flutter_frontend/gradlew build

Root-level shims are provided to help tools that require ./gradlew and settings.gradle at the repo root.
