# Building the Android app

This repository contains a nested Android Gradle project.

Android project root:
- smart-personal-assistant-178449-178459/android_flutter_frontend

Build using helper script from repo root:
  ./smart-personal-assistant-178449-178459/gradlew-android.sh build

Or build directly from Android project root:
  cd smart-personal-assistant-178449-178459/android_flutter_frontend
  ./gradlew build

Key Gradle files:
- settings.gradle.dcl
- gradlew, gradlew.bat
- gradle/wrapper/gradle-wrapper.properties

If an analyzer cannot locate the project root, configure it to use:
smart-personal-assistant-178449-178459/android_flutter_frontend
