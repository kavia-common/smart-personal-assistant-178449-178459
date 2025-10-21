@echo off
REM Proxy to the nested project Gradle wrapper
cd android_flutter_frontend
call gradlew.bat %*
