#!/usr/bin/env bash
# Delegates gradle commands to the nested Android project.
# Usage: ./gradlew-android.sh <gradle-args>
set -euo pipefail
cd "$(dirname "$0")/android_flutter_frontend"
exec ./gradlew "$@"
