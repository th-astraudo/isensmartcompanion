package fr.isen.straudo.isensmartcompanion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import fr.isen.straudo.isensmartcompanion.ui.theme.ISENSmartCompanionTheme
import fr.isen.straudo.isensmartcompanion.navigation.MainApp


import retrofit2.http.GET

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ISENSmartCompanionTheme {
                MainApp() // L'application démarre avec MainApp()
            }
        }
    }
}

interface ApiService {
    @GET("events.json")
    suspend fun getEventList(): List<Event>
}