# Building

This repository contains a nested Android Gradle project (Declarative DSL).

Android Gradle project root:
- smart-personal-assistant-178449-178459/android_flutter_frontend

Build from repo root using helper:
  ./smart-personal-assistant-178449-178459/gradlew-android.sh build

Or build directly from the Android project root:
  cd smart-personal-assistant-178449-178459/android_flutter_frontend
  ./gradlew build

Other helpers:
- make android-build
- ./smart-personal-assistant-178449-178459/build-android.sh
- ./smart-personal-assistant-178449-178459/run-android-tests.sh

Note for analyzers/CI:
If automatic discovery fails, set the working directory to:
smart-personal-assistant-178449-178459/android_flutter_frontend
