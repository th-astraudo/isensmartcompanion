package fr.isen.straudo.isensmartcompanion.ui.screens

import fr.isen.straudo.isensmartcompanion.generateFakeEvents


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EventsScreen() {
    val eventsList = generateFakeEvents()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Événements ISEN")

        LazyColumn {
            items(eventsList) { event ->
                Text(event.title)
            }
        }
    }
}
