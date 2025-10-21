# Permissions Center Deep Link

For quick QA access to the Permissions Center, use the deep link:

- URI: app://org.example.app/permissions-center

How to trigger:
- From adb: `adb shell am start -a android.intent.action.VIEW -d "app://org.example.app/permissions-center"`
- From tests: `navController.navigate(R.id.deeplink_permissions_center)`

Notes:
- This deep link is registered in `res/navigation/nav_graph.xml` under the `permissionsCenterFragment` destination.
- Intended for QA/testing convenience and internal tooling.
