import java.io.File

println("This is a root-level shim. Build the Android project via './gradlew' (shim) which delegates into smart-personal-assistant-178449-178459/android_flutter_frontend.")
tasks.register("helpAndroid") {
    doLast {
        println("Run: ./gradlew -p smart-personal-assistant-178449-178459/android_flutter_frontend tasks")
    }
}
