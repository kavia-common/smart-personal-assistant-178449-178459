# Work Integration Notes (Permissions-aware Scheduling)

Where to schedule background tasks after permissions are granted:
- Location/Media/SMS permissions managed by: core/permissions/PermissionsManager.kt
- UI entry point to invoke background work after a successful grant:
  - PermissionsCenterFragment: in the onResult callback of request launcher, call WorkScheduler.enqueueImageAnalysisOnce(requireContext()) to trigger a one-shot job (when MEDIA granted).
  - Future screens can query PermissionsManager.getStatus(...) and schedule based on status.

Stubbed components:
- core/work/WorkScheduler.kt (enqueueImageAnalysisOnce)
- core/work/PlaceholderWorker.kt

Next steps:
- Implement real workers (e.g., MediaScanWorker) with proper constraints.
- Add feature gating with PermissionsManager.isAnyPermissionMissing(...) before scheduling.
- Migrate SharedPreferences to DataStore (see core/permissions/DATASTORE_MIGRATION_NOTES.md).
