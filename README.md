# compose-drag-drop-list

![drag-drop](https://github.com/VincentVInsideApp/compose-drag-drop-list/assets/97438364/85ae269e-227c-43e1-b073-0182e08e54f2)


# Overview
The DragDropList composable is a composable that enables drag-and-drop reordering of items in a list. It is designed to work seamlessly with Jetpack Compose and can be easily integrated into your Compose-based Android application.

# Usage
See the example app

    DragDropList(
        items = myList,
        onMove = { from, to ->
            // Update the list using the mutable state variable
            val fromItem = myList[from]
            val toItem = myList[to]
            val newList = myList.toMutableList()
            newList[from] = toItem
            newList[to] = fromItem
            myList = newList // Update the mutable state
        },
        onDragFinished = { // Do heavy task here (like room DB update) }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
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
        Spacer(modifier = Modifier.height(8.dp))
    }

# Parameters
```items```: A list of items to be displayed in the drag-and-drop list.

```onMove```: A lambda that is called when an item is moved. It provides the fromIndex and toIndex of the item being moved, allowing you to update your data accordingly.

```onDragFinished```: Called when the drag n drop is terminated. use it for heavy tasks (Room DB update for example)

```modifier```: An optional modifier that can be used to customize the appearance and behavior of the DragDropList.

```itemComposable```: A lambda that takes an item from the items list and defines how it should be displayed within the list.


# Features
<b>Drag-and-Drop Reordering</b>: Users can reorder items in the list by simply dragging and dropping them to their desired position.

<b>Smooth Animations</b>: The composable provides smooth animations for item transitions during drag-and-drop operations.

<b>Customization</b>: You can customize the appearance of each item by providing your own itemComposable lambda.
