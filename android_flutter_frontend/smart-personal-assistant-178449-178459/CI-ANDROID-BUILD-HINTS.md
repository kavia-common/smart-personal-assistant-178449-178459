# CI Android Build Hints

Android project root directory:
- android_flutter_frontend/

Use the Gradle wrapper inside the Android project:
- Unix/macOS:
  ./android_flutter_frontend/gradlew -p android_flutter_frontend build
- Windows:
  android_flutter_frontend\gradlew.bat -p android_flutter_frontend build

Notes:
- This project uses the Gradle Declarative DSL (settings.gradle.dcl and build.gradle.dcl).
- If your CI requires conventional settings at the repo root, a discovery-only settings.gradle and build.gradle are provided that include the Android modules.
