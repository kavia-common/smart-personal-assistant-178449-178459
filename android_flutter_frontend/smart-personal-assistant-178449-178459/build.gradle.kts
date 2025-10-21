import java.io.File

// This root-level build file is a shim to assist tooling that expects a build script at repository root.
// It delegates to the real Android project located under android_flutter_frontend.
gradle.taskGraph.whenReady {
    logger.lifecycle("Delegating Gradle invocation to android_flutter_frontend module...")
}

// Provide a helpful task that invokes the module wrapper via Exec for common entry points
tasks.register<Exec>("assembleDebug") {
    group = "build"
    description = "Delegates to android_flutter_frontend :app:assembleDebug"
    workingDir = File(rootDir, "android_flutter_frontend")
    commandLine("./gradlew", ":app:assembleDebug")
}

tasks.register<Exec>("build") {
    group = "build"
    description = "Delegates to android_flutter_frontend build"
    workingDir = File(rootDir, "android_flutter_frontend")
    commandLine("./gradlew", "build")
}
