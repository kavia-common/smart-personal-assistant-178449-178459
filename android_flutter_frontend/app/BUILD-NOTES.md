# Build Notes

- Gradle Wrapper: use `./gradlew` from android_flutter_frontend
- Default task: `:app:assembleDebug`
- ProGuard/R8 rules: see `app/proguard-rules.pro` (placeholder for now)
- Testing placeholders:
  - androidTest manifest exists to help analyzers discover project structure.
- Navigation:
  - Permissions Center: `org.example.app.ui.permissions.PermissionsCenterFragment` (bottom nav + Settings + deep link)
- Step 02:
  - Permissions manifest entries are SDK-aware; SMS is optional (behind explicit opt-in)
  - PermissionsManager handles runtime flows; UI reflects statuses and actions
