# Declarative Gradle Project

This Android project uses the experimental Gradle Declarative Configuration Language.

Key files:
- settings.gradle.dcl (project settings)
- app/build.gradle.dcl, utilities/build.gradle.dcl, list/build.gradle.dcl (module configs)

Build with the wrapper here:
- ./gradlew build
or from repo root:
- ./android_flutter_frontend/gradlew -p android_flutter_frontend build
