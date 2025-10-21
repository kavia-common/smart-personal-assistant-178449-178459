#!/usr/bin/env bash
set -euo pipefail
# CI helper to build the Android app from the module root
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
exec "${SCRIPT_DIR}/android_flutter_frontend/gradlew" :app:assembleDebug
