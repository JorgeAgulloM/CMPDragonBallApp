package com.example.dragonballapp.data.remote

import co.touchlab.kermit.Logger
import com.example.dragonballapp.data.remote.response.CharacterWrapperResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(private val client: HttpClient) {

    suspend fun getAllCharacters(): CharacterWrapperResponse {
        return try {
            client.get("/api/characters/") {
                parameter("limit", 60)
            }.body()
        } catch (e: Exception) {
            Logger.e("Error API SERVICE -> ${e.message}")
            return CharacterWrapperResponse(items = emptyList())
        }
    }
}