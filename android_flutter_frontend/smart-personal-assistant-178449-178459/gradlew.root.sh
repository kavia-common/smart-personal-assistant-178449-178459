#!/usr/bin/env bash
# Root-level gradle wrapper proxy to nested Android project.
set -euo pipefail
cd "$(dirname "$0")/android_flutter_frontend"
exec ./gradlew "$@"
