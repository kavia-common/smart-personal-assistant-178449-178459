@echo off
REM Proxy Gradle wrapper at repo root -> nested Android project
cd android_flutter_frontend
call gradlew.bat %*
