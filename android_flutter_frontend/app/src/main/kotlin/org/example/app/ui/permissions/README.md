# Permissions UI Package

Screens
- PermissionsCenterFragment: Centralized management of Location, Media, and optional SMS permissions.
- PermissionsHelpFragment: Quick reference and guidance for managing permissions and resolving denied states.

Key UX flows
- Shows status (Granted/Denied/Permanently Denied/Not Requested)
- Requests runtime permissions with Activity Result APIs
- Links to system App Settings when permanently denied
- Optional SMS is gated behind explicit in-app opt-in

Notes
- Titles are set onResume for consistent app bar behavior.
- Media rationale text updates dynamically based on SDK version.
