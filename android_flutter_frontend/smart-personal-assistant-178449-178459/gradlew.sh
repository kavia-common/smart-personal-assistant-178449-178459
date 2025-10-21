#!/usr/bin/env bash
set -euo pipefail
# Convenience wrapper to help CI/analyzers starting at repo root
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
MOD_ROOT="${SCRIPT_DIR}/android_flutter_frontend"
if [ -x "${MOD_ROOT}/gradlew" ]; then
  exec "${MOD_ROOT}/gradlew" "$@"
else
  echo "Gradle wrapper not found at ${MOD_ROOT}/gradlew" >&2
  exit 1
fi
