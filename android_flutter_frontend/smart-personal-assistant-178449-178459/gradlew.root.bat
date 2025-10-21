@echo off
REM Root-level Gradle proxy to nested Android project wrapper
cd android_flutter_frontend
call gradlew.bat %*
