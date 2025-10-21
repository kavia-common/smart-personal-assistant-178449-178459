#!/usr/bin/env bash
# Proxy script to run Gradle tasks inside the nested Android project from repository root.
# Usage: ./gradle-proxy.sh <gradle-args>
set -euo pipefail
cd "$(dirname "$0")/android_flutter_frontend"
exec ./gradlew "$@"
