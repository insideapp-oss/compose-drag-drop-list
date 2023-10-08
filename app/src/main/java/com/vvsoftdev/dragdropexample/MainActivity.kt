package com.vvsoftdev.dragdropexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vvsoftdev.compose_drag_drop_list.DragDropList
import com.vvsoftdev.dragdropexample.ui.theme.DragDropExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DragDropExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var fruits by remember {
                        mutableStateOf(
                            listOf(
                                "apple",
                                "banana",
                                "cherry",
                                "date",
                                "elderberry",
                                "fig",
                                "grape",
                                "kiwi",
                                "lemon",
                                "mango",
                                "orange",
                                "papaya",
                                "quince",
                                "raspberry",
                                "strawberry",
                                "tangerine",
                                "watermelon"
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    DragDropList(
                        items = fruits,
                        onMove = { from, to ->
                            // Update the list using the mutable state variable
                            val fromItem = fruits[from]
                            val toItem = fruits[to]
                            val newList = fruits.toMutableList()
                            newList[from] = toItem
                            newList[to] = fromItem
                            fruits = newList // Update the mutable state
                            Log.d("DRAG_N_DROP", "Move $to $from")
                        },
                        onDragFinished = {
                            //Do heavy tasks here for example a room database update...
                            Log.d("DRAG_N_DROP", "Drag is finished")
                        }
                    ) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(64.dp),
                            elevation = 4.dp,
                            backgroundColor = MaterialTheme.colors.primary,
                            border = BorderStroke(1.dp, MaterialTheme.colors.secondary),
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    it,
                                    color = Color.White,
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
