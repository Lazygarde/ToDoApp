package com.example.todoapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.data.ToDo
import com.example.todoapp.data.getToDoList
import com.example.todoapp.ui.DetailScreen
import com.example.todoapp.ui.ListScreen
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
                    val navigator = rememberNavController()
                    val a = getToDoList()
                    NavHost(navController = navigator, startDestination = "list") {
                        composable("list") {
                            ListScreen(toDos = a, onClick = {
                                Log.d("navigate", "12345567")
                                navigator.navigate("detail/$it")
                            })
                        }
                        composable("detail/{id}") {
                            val index = it.arguments?.getString("id")!!.toInt()
                            DetailScreen(toDo = a[index], onClick = {
                                navigator.navigate("list")
                            })
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "main"
) {
    Column {
        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = startDestination
        ) {
            composable("main") {
                MainScreen(
                    click = { navController.navigate("main/$it") },
                    /*...*/
                )
            }
            composable("main/1") {
                Screen1(
                    onNavigateToFriends = { navController.navigate("main") }
                )
            }
            composable("main/2") {
                Screen2(
                    onNavigateToFriends = { navController.navigate("main") }
                )
            }
            composable("main/3") {
                Screen3(
                    onNavigateToFriends = { navController.navigate("main") }
                )
            }
        }

    }

}

@Composable
fun Screen1(onNavigateToFriends: () -> Unit) {
    Column {

        Text(text = "screen 1")
        Button(onClick = onNavigateToFriends) {
            Text(text = "back")
        }
    }
}

@Composable
fun Screen2(onNavigateToFriends: () -> Unit) {
    Column {

        Text(text = "screen 2")
        Button(onClick = onNavigateToFriends) {
            Text(text = "back")
        }
    }
}

@Composable
fun Screen3(onNavigateToFriends: () -> Unit) {
    Column {

        Text(text = "screen 3")
        Button(onClick = onNavigateToFriends) {
            Text(text = "back")
        }
    }
}

@Composable
fun MainScreen(
    click: (Int) -> Unit
) {
    Column {
        Button(onClick = { click(1) }) {
            Text(text = "to 1")
        }
        Button(onClick = { click(2) }) {
            Text(text = "to 2")
        }
        Button(onClick = { click(3) }) {
            Text(text = "to 3")
        }
    }

}