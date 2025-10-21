# Android Quickstart (Nested Gradle Project)

Android Gradle project root:
- smart-personal-assistant-178449-178459/android_flutter_frontend

Build:
- cd smart-personal-assistant-178449-178459/android_flutter_frontend
- ./gradlew build

Install (debug):
- ./gradlew :app:installDebug

Run tests:
- ./gradlew test

Notes:
- This repo uses Gradle Declarative DSL (settings.gradle.dcl) with compatibility settings.gradle for tools.
- If your tool cannot auto-detect the Gradle root, set working directory to android_flutter_frontend.
