# SharedPreferences Keys (Step 02)

Temporary keys used for permission flows before DataStore migration:

- perm_requested_<GROUP_NAME> — tracks if a group has been requested at least once
- perm_opt_in_<GROUP_NAME> — tracks user opt-in status for optional groups (e.g., SMS)

Groups:
- LOCATION
- MEDIA
- SMS

Note: Will be migrated to Jetpack DataStore in Step 03.
