#!/usr/bin/env bash
# Lists available Gradle tasks for the nested Android project.
set -euo pipefail
cd "$(dirname "$0")/android_flutter_frontend"
./gradlew --no-daemon tasks
