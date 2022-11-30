package com.example.todoapp.ui.screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.ui.buttonnav.BottomNavigation
import com.example.todoapp.ui.buttonnav.NavigationGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenView(onClick: (Int) -> Unit) {
    val bottomNavController = rememberNavController()
    Scaffold(bottomBar = { BottomNavigation(bottomNavController) }
    ) { innerPadding ->
        NavigationGraph(navController = bottomNavController, innerPadding = innerPadding, onClick)
    }
}