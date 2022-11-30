package com.example.todoapp.ui.buttonnav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todoapp.data.getToDoList
import com.example.todoapp.ui.screen.CalendarScreen
import com.example.todoapp.ui.screen.DeletedScreen
import com.example.todoapp.ui.screen.ListScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    innerPadding: PaddingValues,
    onclick: (Int) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.ListScreen.screen_route,
        Modifier.padding(innerPadding)
    ) {
        composable(BottomNavItem.ListScreen.screen_route) {
            ListScreen(toDos = getToDoList(), onClick = onclick)
        }
        composable(BottomNavItem.CalendarScreen.screen_route) {
            CalendarScreen()
        }
        composable(BottomNavItem.DeletedScreen.screen_route) {
            DeletedScreen()
        }
    }
}