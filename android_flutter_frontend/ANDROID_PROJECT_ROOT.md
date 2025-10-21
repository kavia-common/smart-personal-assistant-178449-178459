# Android Project Root and Build Guide

Project root for Android module:
- smart-personal-assistant-178449-178459/android_flutter_frontend

Why this doc?
- Some CI/scanner tools attempt to build from repository root. This repository contains multiple assets; the actual Android Gradle project lives under the path above and uses Gradle Declarative (.dcl) settings.

How to build locally:
1) Change into the Android project directory:
   cd smart-personal-assistant-178449-178459/android_flutter_frontend
2) Build:
   ./gradlew build
3) Install debug on a connected device:
   ./gradlew :app:installDebug

Modules included:
- :app
- :list
- :utilities

Notes:
- The project uses settings.gradle.dcl (Declarative Gradle).
- If your CI requires invoking from repo root, use the root `./gradlew` shim added in this repository which delegates to the Android project.
