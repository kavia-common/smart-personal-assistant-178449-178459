# Android Module Root (Build Here)

This directory is the Android project root (uses Gradle Declarative .dcl).
- settings.gradle.dcl is in this directory
- Gradle wrapper is in this directory
- Modules included: :app, :list, :utilities

Build:
- ./gradlew build

Install debug:
- ./gradlew :app:installDebug

If running builds from repository root, a gradlew shim is available:
- ./gradlew build  (delegates into this module)
