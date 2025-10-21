# Building the Android app

This Android project uses Gradle 9 Declarative DSL (.dcl). Build from this directory:

- ./gradlew :app:assembleDebug
- ./gradlew build

Project entry points:
- settings.gradle.dcl
- app/build.gradle.dcl

Modules:
- app (application)
- list (library)
- utilities (library)
