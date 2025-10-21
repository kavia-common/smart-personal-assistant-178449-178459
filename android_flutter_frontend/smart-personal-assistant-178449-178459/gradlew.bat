@echo off
REM Proxy Gradle wrapper to the nested Android project for Windows environments.
setlocal enabledelayedexpansion
set SCRIPT_DIR=%~dp0
cd /d "%SCRIPT_DIR%\android_flutter_frontend"
call .\gradlew.bat %*
