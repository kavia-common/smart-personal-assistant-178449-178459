pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.experimental.android-ecosystem").version("0.1.43")
}

rootProject.name = "smart-personal-assistant-root-shim"

// Delegate to the actual Android project located under android_flutter_frontend
apply(from = file("android_flutter_frontend/settings.gradle.dcl"))
