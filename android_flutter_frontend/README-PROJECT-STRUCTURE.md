# Project Structure Notes

This Android app uses Gradle 9 Declarative (.dcl) configuration:
- Root settings: `settings.gradle.dcl`
- App module: `app/` (Android application)
- Library modules: `list/`, `utilities/`
- Kotlin source: `app/src/main/kotlin/...`
- Resources: `app/src/main/res/...`
- Manifest: `app/src/main/AndroidManifest.xml`

Navigation graph: `app/src/main/res/navigation/nav_graph.xml`  
Primary Activity: `app/src/main/kotlin/org/example/app/MainActivity.kt`  
Entry Application: `app/src/main/kotlin/org/example/app/App.kt`

If a tool attempts to infer the project root, the correct root is:
`smart-personal-assistant-178449-178459/android_flutter_frontend/`

Gradle wrapper is present at:
`smart-personal-assistant-178449-178459/android_flutter_frontend/gradlew`
