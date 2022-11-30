package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.data.getToDoList
import com.example.todoapp.ui.screen.DetailScreen
import com.example.todoapp.ui.screen.MainScreenView
import com.example.todoapp.ui.theme.ToDoAppTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val a = getToDoList()
                    val mainNavController = rememberNavController()
                    NavHost(navController = mainNavController, startDestination = "main") {
                        composable("main") {
                            MainScreenView(onClick = {
                                mainNavController.navigate("detail/$it")
                            })
                        }
                        composable("detail/{id}") {
                            val index = it.arguments?.getString("id")!!.toInt()
                            DetailScreen(toDo = a[index], onClick = {
                                mainNavController.navigate("main")
                            })
                        }
                    }
                }
            }
        }
    }
}