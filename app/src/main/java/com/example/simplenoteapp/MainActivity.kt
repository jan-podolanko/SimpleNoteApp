package com.example.simplenoteapp

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Display()
        }
    }
}

/*@Composable
fun NoteDisplay() {
    var textFieldState by remember {
        mutableStateOf("")
    }
    TextField(
        value = textFieldState,
        onValueChange = { textFieldState = it }
    )
}*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Display() {
    val scope = rememberCoroutineScope()

    data class Items(val id: Int, val name: String)

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("Saved Notes") },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                navigationIcon = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(Icons.Filled.Menu, contentDescription = "Localized description")
                    }
                }
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                onClick = { scope.launch { } }) {
                Icon(Icons.Filled.Add, "")
            }
        },

        content = {
            LazyColumn {
                items(50) { i ->
                    Surface(
                        onClick = {},
                        shape = RoundedCornerShape(30.dp),
                        border = BorderStroke(3.dp, MaterialTheme.colorScheme.primary),
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shadowElevation = 15.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 25.dp, vertical = 5.dp)
                    ) {
                        Text(
                            text = "Sample item ${i + 1}",
                            textAlign = TextAlign.Center,
                            fontSize = 17.sp,
                            modifier = Modifier
                                .padding(12.dp)
                        )
                    }
                }
            }
        }
    )
}