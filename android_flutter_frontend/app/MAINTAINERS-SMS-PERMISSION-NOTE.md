# SMS Permission (READ_SMS) — Maintainers Note

Purpose:
- SMS parsing is optional and requires explicit user opt-in inside the app.
- Used only for local parsing of transaction summaries to enhance spending insights.

Play policy and release toggling:
- If your release build should NOT request SMS, remove or disable the permission via product flavors or tooling:
  - In AndroidManifest (merge-time remove):
    <uses-permission android:name="android.permission.READ_SMS" tools:node="remove" />
- Ensure the app experience gracefully hides any SMS-related UI/flows when SMS is disabled.

Developer tips:
- The Permissions Center will only request SMS permission after the user toggles the in-app opt-in switch.
- For QA, the deep link app://org.example.app/permissions-center can be used to jump straight to the Permissions Center.
