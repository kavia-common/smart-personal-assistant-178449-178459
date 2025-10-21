#!/usr/bin/env bash
# Helper to run Gradle tasks from the Android project root.
# Usage: ./run-gradle.sh <gradle-task>
set -euo pipefail
DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$DIR"
./gradlew "$@"
