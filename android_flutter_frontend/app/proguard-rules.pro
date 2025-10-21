# Default proguard rules (placeholder). This project does not enable minify by default.
# Keep WorkManager and Fragment subclasses’ default constructors if minify is enabled in future.
-keepclassmembers class * extends androidx.work.ListenableWorker {
    <init>(android.content.Context, androidx.work.WorkerParameters);
}
-keep class ** extends androidx.fragment.app.Fragment

# Keep AndroidX Navigation generated classes and directions (if used in future)
-keep class **NavDirections { *; }
-keep class **Directions { *; }
-keep class androidx.navigation.** { *; }
-keepclassmembers class * {
    @androidx.navigation.NavArgsClass *;
}
