#!/usr/bin/env bash
# Opens the nested Android project in Android Studio.
# Usage: ./open-in-android-studio.sh
set -euo pipefail
PROJECT_DIR="$(cd "$(dirname "$0")/android_flutter_frontend" && pwd)"
if command -v studio >/dev/null 2>&1; then
  studio "$PROJECT_DIR"
elif command -v android-studio >/dev/null 2>&1; then
  android-studio "$PROJECT_DIR"
else
  echo "Android Studio launcher not found (studio/android-studio). Open manually at: $PROJECT_DIR"
fi
