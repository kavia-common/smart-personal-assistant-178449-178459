#!/usr/bin/env bash
# Runs Android Lint for the nested Gradle project from the repository root.
set -euo pipefail
cd "$(dirname "$0")/android_flutter_frontend"
./gradlew --no-daemon --stacktrace :app:lint
