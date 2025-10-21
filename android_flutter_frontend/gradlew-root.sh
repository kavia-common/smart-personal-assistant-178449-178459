#!/usr/bin/env bash
# Helper to run Gradle from the nested Android project root when analyzers expect a gradlew-like entrypoint.
set -euo pipefail
exec ./gradlew "$@"
