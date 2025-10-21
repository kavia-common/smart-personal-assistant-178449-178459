#!/usr/bin/env bash
set -euo pipefail
# Build helper: run from android module root
exec ./gradlew :app:assembleDebug
