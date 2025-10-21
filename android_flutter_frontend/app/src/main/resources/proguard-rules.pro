# Keep WorkManager Worker subclasses to prevent obfuscation issues with reflection-based instantiation
-keep class ** extends androidx.work.ListenableWorker { *; }
-keep class ** extends androidx.work.Worker { *; }
-keep class ** extends androidx.work.CoroutineWorker { *; }

# Keep generated Navigation classes and R (safety)
-keepclassmembers class **.R$* { *; }
-keep class androidx.navigation.** { *; }

# WorkManager startup (if used) and internal reflectively-referenced classes
-keep class androidx.work.impl.** { *; }
-keep class androidx.startup.** { *; }
