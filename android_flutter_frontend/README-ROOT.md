# Android Gradle Project Root

This directory is the root of the Android Gradle project.

Key files:
- settings.gradle.dcl (Declarative Gradle DSL)
- gradlew / gradlew.bat (Gradle wrapper)
- app/, utilities/, list/ modules

Build examples:
- ./gradlew build
- ./gradlew :app:installDebug

Notes for analyzers/CI:
- Treat this directory as the Gradle project root.
- If your tooling only recognizes settings.gradle(.kts), see the discovery hints at repository root which delegate to this directory.
