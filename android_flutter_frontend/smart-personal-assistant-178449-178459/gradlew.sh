#!/usr/bin/env sh
# Minimal wrapper to run the nested Android project's Gradle wrapper from the repo root.
set -eu
cd "$(dirname "$0")/android_flutter_frontend"
exec ./gradlew "$@"
