#!/usr/bin/env bash
# Prints the absolute path to the nested Android Gradle project root, if present.
set -euo pipefail
ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"
ANDROID_DIR="$ROOT_DIR/android_flutter_frontend"
if [ -f "$ANDROID_DIR/settings.gradle.dcl" ] && [ -x "$ANDROID_DIR/gradlew" ]; then
  echo "$ANDROID_DIR"
  exit 0
fi
echo "Android Gradle root not found" >&2
exit 1
