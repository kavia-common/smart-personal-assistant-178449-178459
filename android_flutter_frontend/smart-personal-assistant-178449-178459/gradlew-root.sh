#!/usr/bin/env bash
# Root-level helper to invoke the nested Android project's Gradle wrapper.
set -euo pipefail
cd android_flutter_frontend
exec ./gradlew "$@"
