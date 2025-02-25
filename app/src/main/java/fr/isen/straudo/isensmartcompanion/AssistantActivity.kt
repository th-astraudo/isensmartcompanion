package fr.isen.straudo.isensmartcompanion


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.isen.straudo.isensmartcompanion.ui.theme.ISENSmartCompanionTheme

class AssistantActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ISENSmartCompanionTheme {
                AssistantScreen()  // Appeler votre AssistantScreen ici
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssistantScreen() {
    var question by remember { mutableStateOf("") }
    var response by remember { mutableStateOf("Réponse de l'IA : $question") }
    val context = LocalContext.current

    Box(
            modifier = Modifier
            .fillMaxSize()
        .padding(16.dp)
    ) {
        // Conteneur du logo et du titre
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(bottom = 16.dp)
                )
                Text(
                    text = "Smart Companion",
                    color = Color.Blue,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }

        // Conteneur pour le champ de texte et le bouton
        Box(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                TextField(
                    value = question,
                    onValueChange = { question = it },
                    label = { Text("Posez votre question ici") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        response = fakeAIResponse(question)
                        Toast.makeText(context, "Question Submitted", Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Envoyer")
                }
            }
        }

        // Conteneur pour afficher la réponse
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 32.dp)
        ) {
            Text(
                text = response,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

// Fonction qui génère une fausse réponse
fun fakeAIResponse(question: String): String {
    return if (question.isNotBlank()) {
        "Ceci est une réponse générée pour : $question"
    } else {
        "Veuillez poser une question !"
    }
}

// Preview
@Preview(showBackground = true)
@Composable
fun AssistantScreenPreview() {
    ISENSmartCompanionTheme {
        AssistantScreen()
    }
}