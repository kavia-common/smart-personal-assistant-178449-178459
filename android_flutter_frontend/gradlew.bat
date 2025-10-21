@echo off
REM Android project root Gradle wrapper (Windows)
set DIRNAME=%~dp0
set ANDROID_ROOT=%DIRNAME%

"%ANDROID_ROOT%\gradlew" %*
