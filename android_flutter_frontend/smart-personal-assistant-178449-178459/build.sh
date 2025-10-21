#!/usr/bin/env bash
set -euo pipefail
# CI helper: build Android module using its Gradle wrapper
cd "$(dirname "$0")/android_flutter_frontend"
./gradlew :app:assembleDebug
