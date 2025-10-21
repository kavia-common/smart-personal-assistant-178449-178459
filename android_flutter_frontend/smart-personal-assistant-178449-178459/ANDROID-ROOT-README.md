# Android Project Root Pointer

This repository hosts an Android project under:
- android_flutter_frontend/

Build using the module's Gradle wrapper:
- ./android_flutter_frontend/gradlew :app:assembleDebug
- ./android_flutter_frontend/gradlew build

Key files:
- android_flutter_frontend/settings.gradle.dcl
- android_flutter_frontend/app/build.gradle.dcl

If your CI or analyzer starts from repository root, use:
- make build
- ./gradlew (root shim) or ./gradlew.sh
- ./ci-build.sh
