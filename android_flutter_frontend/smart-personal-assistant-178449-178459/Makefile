# Root-level Makefile delegating to the nested Android Gradle project

ANDROID_DIR := smart-personal-assistant-178449-178459/android_flutter_frontend

.PHONY: help android-build android-clean android-test

help:
	@echo "Available targets:"
	@echo "  make android-build  - Build the Android project"
	@echo "  make android-clean  - Clean the Android project"
	@echo "  make android-test   - Run unit tests for the Android project"

android-build:
	@cd $(ANDROID_DIR) && ./gradlew --no-daemon --stacktrace build

android-clean:
	@cd $(ANDROID_DIR) && ./gradlew --no-daemon clean

android-test:
	@cd $(ANDROID_DIR) && ./gradlew --no-daemon test
