# WorkManager Stubs (Step 02)

This directory contains placeholder background work for future use:

- MediaIndexWorker: a no-op `CoroutineWorker` intended to index/analyze media locally.
- WorkSchedulers: a helper that enqueues the worker with basic constraints.

Integration plan (Step 03+):
1. After the user grants Media permission (READ_MEDIA_IMAGES on Android 13+ or READ_EXTERNAL_STORAGE on older), enqueue `WorkSchedulers.enqueueMediaIndexIfEligible(context)`.
2. Add constraints and backoff policies as needed (charging, unmetered network).
3. Ensure scheduling respects user opt-ins and in-app toggles.

Note:
- Obfuscation/minification: see `app/src/main/resources/proguard-rules.pro` for keep rules on Worker classes.
