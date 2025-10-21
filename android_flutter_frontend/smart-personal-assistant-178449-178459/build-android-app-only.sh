#!/usr/bin/env bash
# CI/helper: Build only the Android :app module in the nested Gradle project.
set -euo pipefail
cd "$(dirname "$0")/android_flutter_frontend"
./gradlew --no-daemon --stacktrace :app:assembleDebug :app:assembleRelease
