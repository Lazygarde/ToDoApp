package com.example.todoapp.ui.screen


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.data.ToDo
import com.example.todoapp.data.getToDoList

@Composable
fun ListScreen(modifier: Modifier = Modifier, toDos: List<ToDo>, onClick: (Int) -> Unit) {
    Column {
        Text(
            text = "Notes",
            modifier = modifier.padding(start = 25.dp, top = 20.dp),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
        LazyColumn(modifier = modifier.padding(start = 20.dp, end = 20.dp, top = 10.dp)) {
            itemsIndexed(toDos) { index, toDo ->
                ToDoItem(toDo = toDo, index = index, onClick = onClick)
            }
        }
    }

}

@Composable
fun ToDoItem(modifier: Modifier = Modifier, toDo: ToDo, index: Int, onClick: (Int) -> Unit) {
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(5.dp)
        .clickable {
            onClick(index)
        }) {
        Column {
            Text(
                text = toDo.title,
                modifier = modifier.padding(start = 20.dp, top = 15.dp, end = 15.dp),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = toDo.description,
                modifier = modifier.padding(start = 20.dp, end = 15.dp, bottom = 10.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardPreview() {
    ListScreen(toDos = getToDoList(), onClick = {})
}