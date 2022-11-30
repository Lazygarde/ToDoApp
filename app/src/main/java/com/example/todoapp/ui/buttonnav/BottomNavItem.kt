package com.example.todoapp.ui.buttonnav

import com.example.todoapp.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {
    object ListScreen : BottomNavItem("List Screen", R.drawable.icon_list, "list_screen")
    object CalendarScreen : BottomNavItem("Calendar Screen", R.drawable.icon_calendar, "calendar_screen")
    object DeletedScreen : BottomNavItem("Deleted Screen", R.drawable.icon_delete, "deleted_screen")
}