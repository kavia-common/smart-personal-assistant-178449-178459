#!/usr/bin/env bash
# Verifies the nested Android project's Gradle wrapper files exist and are valid.
set -euo pipefail
ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"
WRAPPER_DIR="$ROOT_DIR/android_flutter_frontend/gradle/wrapper"
JAR="$WRAPPER_DIR/gradle-wrapper.jar"
PROPS="$WRAPPER_DIR/gradle-wrapper.properties"

echo "Checking Gradle wrapper at: $WRAPPER_DIR"
[ -f "$JAR" ] && echo "[OK] gradle-wrapper.jar present" || { echo "[ERR] Missing gradle-wrapper.jar" >&2; exit 1; }
[ -f "$PROPS" ] && echo "[OK] gradle-wrapper.properties present" || { echo "[ERR] Missing gradle-wrapper.properties" >&2; exit 2; }

echo "Wrapper verification succeeded."
