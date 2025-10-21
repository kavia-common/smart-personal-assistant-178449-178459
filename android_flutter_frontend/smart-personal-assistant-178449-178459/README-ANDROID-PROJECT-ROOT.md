# Android Project Root Pointer

The Android Gradle project for this repository is nested at:
android_flutter_frontend/

Use this as the Gradle project root (contains settings.gradle.dcl, gradlew, gradlew.bat, gradle/wrapper/).

Build from repository root via helper:
  ./gradlew-android.sh build

Build from nested root:
  cd android_flutter_frontend && ./gradlew build

Tools and analyzers:
- Treat `android_flutter_frontend` as the project root.
- Do not search the repository root for Gradle files; instead, start at the nested path above.
