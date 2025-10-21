# declarative-samples-android-app
A sample Android application written in the Declarative Gradle DSL, using the prototype Declarative Gradle `androidApplication` Software Type defined in the `org.gradle.experimental.android-ecosystem` ecosystem plugin.

## Building and Running

This sample shows the definition of a multiproject Android application implemented using Kotlin 2.0.21 source code.
The project is the result of reproducing the project produced by the `gradle init` command in Gradle 8.9 as an Android project.

To build the project without running, use:

```shell
  ./gradlew build
```

To run the application, first install it on a connected Android device using:

```shell
  :app:installDebug
```

Then search for "Sample Declarative Gradle Android App" and launch app to see a hello world message.

## Permissions Center (Step 02)
For implementation details and maintainer notes, see [app/README-PERMISSIONS.md](app/README-PERMISSIONS.md).

- You can open the Permissions Center from:
  - Settings: tap the "Permissions Center" button
  - Dashboard: use the "Permissions Center" quick action button
- The screen shows current status and lets you request or open system settings for:
  - Location
  - Media & Gallery (SDK-aware)
  - SMS (optional; requires explicit opt-in)
- Temporary opt-ins are stored in SharedPreferences and will be migrated to DataStore in the next step.