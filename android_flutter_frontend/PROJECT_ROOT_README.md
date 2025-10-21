# Android Gradle Project Root

This directory is the root of the Android project using Gradle 9 Declarative DSL.

Key files:
- settings.gradle.dcl
- gradle/wrapper/gradle-wrapper.properties
- gradlew, gradlew.bat

Modules:
- :app
- :utilities
- :list

Building from this directory:
  ./gradlew build

If invoked from repository root, use the helper:
  ./gradlew-android.sh build

Note to analyzers/CI:
Use this path as the project root when running any Gradle or static analysis tasks.
