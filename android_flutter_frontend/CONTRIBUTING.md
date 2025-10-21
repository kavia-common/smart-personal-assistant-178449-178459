# Contributing and Local Build Notes

Project root (for Gradle): `smart-personal-assistant-178449-178459/android_flutter_frontend`

Common commands:
- Build all modules: `./gradlew build`
- Install debug APK: `./gradlew :app:installDebug`
- Clean: `./gradlew clean`

Modules:
- App module: `app/`
- Libraries: `utilities/`, `list/`

Navigation graph: `app/src/main/res/navigation/nav_graph.xml`  
Manifest: `app/src/main/AndroidManifest.xml`

Gradle uses Declarative DSL (.dcl) files:
- Root settings: `settings.gradle.dcl`
- Module builds: `*/build.gradle.dcl`

Note: If tooling cannot infer the project root automatically, configure it to the path above.
