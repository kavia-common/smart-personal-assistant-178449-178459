# DataStore Migration Notes (Step 03 Preview)

Context:
- PermissionsManager currently uses SharedPreferences to persist:
  - `perm_requested_{GROUP}`: tracks if a group has been requested
  - `perm_opt_in_{GROUP}`: tracks user opt-in for optional permissions (e.g., SMS)

Plan:
1) Introduce Proto/DataStore:
   - Use Preferences DataStore for simplicity: `preferencesDataStore(name = "permissions_prefs")`
   - Keys:
     - `requested_LOCATION`, `requested_MEDIA`, `requested_SMS` (Boolean)
     - `opt_in_SMS` (Boolean)

2) Migration:
   - Use `SharedPreferencesMigration(context, "permissions_prefs")`
   - Map existing keys to DataStore preferences during first read.

3) API updates:
   - Replace SharedPreferences reads/writes in PermissionsManager with suspend functions using DataStore.
   - Provide non-suspending wrappers (using `runBlocking` or caching in-memory) where needed by UI.
   - Keep API signature compatible initially; add async variants for future refactor.

4) Testing:
   - Validate migration by setting SharedPreferences values, then reading from DataStore to confirm values carry over.

Future:
- Consider adding a single source of truth for permission request timestamps and denied counts for analytics/UX improvements.
