package com.example.todoapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.R
import com.example.todoapp.data.ToDo
import com.example.todoapp.ui.theme.ToDoAppTheme

@Composable
fun DetailScreen(toDo: ToDo, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(modifier = modifier.fillMaxSize()) {
        Row(modifier = modifier.padding(start = 10.dp, top = 20.dp, end = 10.dp)) {
            Image(
                modifier = modifier
                    .clickable { onClick() },
                painter = painterResource(id = R.drawable.icon_back),
                contentDescription = "icon_back",
            )
            Spacer(modifier = modifier.weight(1f))
            Image(
                modifier = modifier.padding(end = 15.dp),
                painter = painterResource(id = R.drawable.icon_palette),
                contentDescription = "icon_palette"
            )
            Image(
                modifier = modifier.padding(end = 15.dp),
                painter = painterResource(id = R.drawable.icon_time_picker),
                contentDescription = "icon_palette"
            )
            Image(
                modifier = modifier.padding(end = 15.dp),
                painter = painterResource(id = R.drawable.icon_date_picker),
                contentDescription = "icon_palette"
            )
            Text(text = "Done", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        }

        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 15.dp, bottom = 10.dp, end = 20.dp),
            text = toDo.title,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(start = 30.dp, end = 20.dp, bottom = 20.dp),
            text = toDo.description,
            fontSize = 25.sp
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DetailPreview() {
    ToDoAppTheme {
        DetailScreen(toDo = ToDo("title", "description")) {}
    }

}