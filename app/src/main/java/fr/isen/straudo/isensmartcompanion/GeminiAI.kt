package fr.isen.straudo.isensmartcompanion

import com.google.ai.client.generativeai.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.GenerativeModelConfig
import com.google.ai.client.generativeai.type.Content
import com.google.ai.client.generativeai.type.Part
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object GeminiAI {
    private val apiKey: String = BuildConfig.apiKey

    private val model = GenerativeModel(
        modelName = "gemini-1.5-flash",
        temperature = 0.7f // Ajuste directement la température ici si possible
    )

    suspend fun analyzeText(input: String): String {
        return withContext(Dispatchers.IO) {
            try {
                model.setApiKey(apiKey)  // Utilise la clé API, si applicable
                val response = model.generateContent(Content(Part.text(input)))
                response.text ?: "Pas de réponse générée"
            } catch (e: Exception) {
                "Erreur: ${e.message}"
            }
        }
    }
}
