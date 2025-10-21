#!/usr/bin/env bash
# Verifies and prints details about the nested Android Gradle project root.
set -euo pipefail
ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"
ANDROID_DIR="$ROOT_DIR/android_flutter_frontend"

echo "Repository root: $ROOT_DIR"
echo "Expected Android Gradle root: $ANDROID_DIR"

if [ -d "$ANDROID_DIR" ]; then
  echo "[OK] Found android_flutter_frontend directory."
else
  echo "[ERR] android_flutter_frontend directory not found." >&2
  exit 1
fi

if [ -f "$ANDROID_DIR/settings.gradle.dcl" ]; then
  echo "[OK] Found settings.gradle.dcl"
else
  echo "[ERR] settings.gradle.dcl not found in $ANDROID_DIR" >&2
  exit 2
fi

if [ -x "$ANDROID_DIR/gradlew" ]; then
  echo "[OK] Found gradlew wrapper"
else
  echo "[WARN] gradlew wrapper not executable or missing at $ANDROID_DIR/gradlew"
fi

echo "Modules (expected): :app, :utilities, :list"
echo "Try building with:"
echo "  cd \"$ANDROID_DIR\" && ./gradlew build"
