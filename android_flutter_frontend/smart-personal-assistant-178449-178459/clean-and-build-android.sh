#!/usr/bin/env bash
# Cleans and builds the nested Android Gradle project from repository root.
set -euo pipefail
cd "$(dirname "$0")/android_flutter_frontend"
./gradlew --no-daemon clean build
