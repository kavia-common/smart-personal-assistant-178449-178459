# Permissions Policy Notes

- Location (ACCESS_COARSE/FINE): Requested at runtime; used for contextual insights.
- Media (READ_MEDIA_IMAGES on Android 13+, READ_EXTERNAL_STORAGE on <33): Requested at runtime; used for on-device analysis. No network upload of media.
- SMS (READ_SMS): Optional and OFF by default; only requested after explicit in-app opt-in by the user. Ensure Google Play policy compliance before enabling in production. Consider alternatives (SMS Retriever API, Notifications Listener) if applicable.

User Controls:
- Permissions Center allows users to review statuses, request, and open system settings on permanent denial.
- SMS toggle controls whether the app is allowed to request SMS permission at all.

Storage:
- Temporary SharedPreferences for opt-in in Step 02. Migrate to Jetpack DataStore in Step 03.
