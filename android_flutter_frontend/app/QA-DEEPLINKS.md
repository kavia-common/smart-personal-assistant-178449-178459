# QA Deep Links

Permissions Center:
- URI: app://org.example.app/permissions-center

From adb:
- adb shell am start -a android.intent.action.VIEW -d "app://org.example.app/permissions-center"
