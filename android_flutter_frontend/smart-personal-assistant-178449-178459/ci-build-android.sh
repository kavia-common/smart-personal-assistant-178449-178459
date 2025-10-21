#!/usr/bin/env bash
# Simple CI helper to build the Android project without guessing paths.
# Usage: bash ci-build-android.sh [gradle-task...]
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ANDROID_DIR="${ROOT_DIR}/android_flutter_frontend"

# Optional: respect JAVA_HOME if already set; otherwise try to use system default
if [[ -z "${JAVA_HOME:-}" ]]; then
  echo "JAVA_HOME not set; relying on system java on PATH."
else
  echo "Using JAVA_HOME=${JAVA_HOME}"
fi

cd "${ANDROID_DIR}"
# default to assembling debug if no args
if [[ "$#" -eq 0 ]]; then
  ./gradlew :app:assembleDebug
else
  ./gradlew "$@"
fi
