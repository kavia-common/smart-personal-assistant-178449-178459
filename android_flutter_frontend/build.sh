#!/usr/bin/env bash
# Helper script to run Gradle build from the nested Android project root
set -euo pipefail
exec ./gradlew build
