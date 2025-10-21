#!/usr/bin/env bash
# Runs an arbitrary Gradle task in the nested Android project.
# Usage: ./run-android-gradle-task.sh <task> [additional args...]
set -euo pipefail
if [ $# -lt 1 ]; then
  echo "Usage: $0 <gradle-task> [args...]"
  exit 1
fi
cd "$(dirname "$0")/android_flutter_frontend"
./gradlew --no-daemon --stacktrace "$@"
