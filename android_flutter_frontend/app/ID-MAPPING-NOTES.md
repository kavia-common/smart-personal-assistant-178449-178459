# ID Mapping Notes

For NavigationUI to work seamlessly with BottomNavigationView, the menu item IDs must match destination IDs in `res/navigation/nav_graph.xml`.

- Menu item: `@id/dashboardFragment` -> Destination: `@id/dashboardFragment`
- Menu item: `@id/insightsFragment` -> Destination: `@id/insightsFragment`
- Menu item: `@id/settingsFragment` -> Destination: `@id/settingsFragment`
- Menu item: `@id/permissionsCenterFragment` -> Destination: `@id/permissionsCenterFragment`

If you rename destinations or change IDs, ensure the corresponding menu item IDs are updated to match.
