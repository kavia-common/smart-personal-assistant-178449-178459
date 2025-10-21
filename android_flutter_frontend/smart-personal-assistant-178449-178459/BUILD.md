# Build Instructions

Android project root is under: android_flutter_frontend/

Use the Gradle wrapper inside that directory:

Unix/macOS:
  ./android_flutter_frontend/gradlew -p android_flutter_frontend build

Windows (PowerShell/CMD):
  android_flutter_frontend\gradlew.bat -p android_flutter_frontend build

Notes:
- The Android project uses Declarative Gradle DSL (settings.gradle.dcl and build.gradle.dcl).
- If your CI/analyzer requires settings at the repository root, a discovery-only settings.gradle exists to include the Android modules.
- Primary modules: :app, :utilities, :list
