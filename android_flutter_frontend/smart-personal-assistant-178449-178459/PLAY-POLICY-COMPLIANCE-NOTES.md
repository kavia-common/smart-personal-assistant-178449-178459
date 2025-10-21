# Play Policy Compliance Notes

This project requests the following permissions:

1) Location (ACCESS_COARSE_LOCATION, ACCESS_FINE_LOCATION)
   - Used for contextual insights and nearby recommendations.
   - Requested at runtime with clear rationale.

2) Media (READ_MEDIA_IMAGES on Android 13+, READ_EXTERNAL_STORAGE on <33)
   - Used for on-device analysis of gallery images to provide insights.
   - Requested at runtime with clear rationale.
   - No media is uploaded off-device.

3) SMS (READ_SMS) - Optional
   - OFF by default; requested only after explicit user opt-in inside the app.
   - Intended use: local parsing of transaction-like messages for spend insights.
   - Ensure compliance with Google Play policies before enabling:
     https://support.google.com/googleplay/android-developer/answer/9086427
   - Alternatives to consider: SMS Retriever API, Notification Listener.

User Controls:
- The Permissions Center screen enables review of permissions and actions to request/open system settings on permanent denial.
- SMS opt-in can be toggled on/off at any time.

Data Storage:
- Temporary SharedPreferences storage for opt-in/request flags (Step 02).
- Planned migration to DataStore (Step 03).
