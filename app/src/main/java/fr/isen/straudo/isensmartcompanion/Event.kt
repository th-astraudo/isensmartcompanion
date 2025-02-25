package fr.isen.straudo.isensmartcompanion
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.Date
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.Locale

// Définition du modèle d'événement
data class Event(
    val id: Int,
    val title: String,
    val description: String,
    val date: Date,
    val location: String,
    val category: String
) : Serializable

fun generateFakeEvents(): List<Event> {
    val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val events = mutableListOf<Event>()

    events.add(
        Event(
            id = 1,
            title = "Soirée BDE",
            description = "Une soirée inoubliable organisée par le BDE.",
            date = format.parse("2025-03-15") ?: Date(),
            location = "Salle des fêtes, ISEN",
            category = "Soirée"
        )
    )

    events.add(
        Event(
            id = 2,
            title = "Gala ISEN",
            description = "Le gala annuel avec dîner et animations.",
            date = format.parse("2025-05-20") ?: Date(),
            location = "Hôtel Hilton",
            category = "Gala"
        )
    )

    events.add(
        Event(
            id = 3,
            title = "Journée de Cohésion",
            description = "Une journée pour renforcer l’esprit d’équipe.",
            date = format.parse("2025-04-10") ?: Date(),
            location = "Parc des Expositions",
            category = "Cohésion"
        )
    )

    events.add(
        Event(
            id = 4,
            title = "Soirée du jeudi",
            description = "Une soirée inoubliable au Kudeta.",
            date = format.parse("2025-02-28") ?: Date(),
            location = "Kudeta Bar",
            category = "Soirée"
        )
    )

    events.add(
        Event(
            id = 5,
            title = "Afterwork",
            description = "Venez vous détendre après les cours.",
            date = format.parse("2025-03-05") ?: Date(),
            location = "Café de la paix",
            category = "Afterwork"
        )
    )

    return events
}

@Composable
fun EventItem(event: Event, context: Context) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = event.title, style = MaterialTheme.typography.titleMedium, color = Color.Black)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = event.description, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    // Créer l'Intent pour démarrer EventDetailActivity
                    val intent = Intent(context, EventDetailActivity::class.java).apply {
                        // Passer l'objet Event sérialisé
                        putExtra("event", event)
                    }
                    context.startActivity(intent)
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Détails")
            }
        }
    }
}
