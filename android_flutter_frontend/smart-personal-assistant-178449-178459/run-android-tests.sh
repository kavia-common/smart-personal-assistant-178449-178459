#!/usr/bin/env bash
# Runs Android build and connected tests for the nested Gradle project.
set -euo pipefail
cd "$(dirname "$0")/android_flutter_frontend"
./gradlew --no-daemon --stacktrace assembleDebug
# Only run connectedAndroidTest if an emulator/device is available; otherwise, skip gracefully.
if adb devices | grep -v "List of devices" | grep -q "device$"; then
  ./gradlew --no-daemon --stacktrace connectedAndroidTest
else
  echo "No connected device found; skipping connectedAndroidTest."
fi
