#!/usr/bin/env bash
# CI helper to build the nested Android project.
set -euo pipefail
cd "$(dirname "$0")/android_flutter_frontend"
./gradlew --no-daemon --stacktrace build
