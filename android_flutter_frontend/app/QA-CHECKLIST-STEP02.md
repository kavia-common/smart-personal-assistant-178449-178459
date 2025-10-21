# Step 02 Manual QA Checklist

1) Navigation & Discoverability
- Bottom nav has "Permissions Center" item and opens the screen
- Settings -> Permissions Center button works
- Dashboard permissions hint card navigates to Permissions Center
- Deep link: `adb shell am start -a android.intent.action.VIEW -d "app://org.example.app/permissions-center"`

2) Runtime Permission Flows
- Location: Request, grant, deny, and deny+Don't ask again states reflected properly; opens system settings on permanent denial
- Media: SDK 33+ uses READ_MEDIA_IMAGES; pre-33 uses READ_EXTERNAL_STORAGE
- SMS: Opt-in required; after opt-in, request permission; permanent denial links to system settings

3) Status UI
- Permissions Center shows status chips/texts that update after actions
- Settings screen shows concise statuses for Location, Media, SMS

4) Accessibility
- Titles and key text have contentDescription; headings use bold/size for hierarchy

5) Persistence
- SMS opt-in persists across process death via SharedPreferences

6) Background Work (stub)
- NoOpWorker present; WorkScheduler.enqueueMediaAnalysisIfPermitted compiles; real workers planned in Step 03

Pass criteria: All navigation paths work, permission statuses update correctly, and denial flows link to system settings.
