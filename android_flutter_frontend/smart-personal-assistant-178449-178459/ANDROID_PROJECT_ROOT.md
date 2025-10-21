# Android Project Root

This repository contains an Android multi-module project using Gradle 9 Declarative DSL (.dcl).

- Root directory for Android project: `android_flutter_frontend`
- Gradle settings file: `android_flutter_frontend/settings.gradle.dcl`
- Gradle wrapper: `android_flutter_frontend/gradlew`
- Main application module: `app`

Build examples:
- ./android_flutter_frontend/gradlew :app:assembleDebug
- ./android_flutter_frontend/gradlew build

CI hints:
- moduleRoot=android_flutter_frontend
- wrapper=./android_flutter_frontend/gradlew
- defaultTask=:app:assembleDebug
