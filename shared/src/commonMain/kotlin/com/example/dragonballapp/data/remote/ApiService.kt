package com.example.dragonballapp.data.remote

import co.touchlab.kermit.Logger
import com.example.dragonballapp.data.remote.response.CharacterResponse
import com.example.dragonballapp.data.remote.response.CharacterWrapperResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(private val client: HttpClient) {

    suspend fun getAllCharacters(): CharacterWrapperResponse {
        return try {
            client.get(urlString = URL) {
                parameter("limit", 60)
            }.body()
        } catch (e: Exception) {
            Logger.e("Error API SERVICE -> ${e.message}")
            return CharacterWrapperResponse(items = emptyList())
        }
    }

    suspend fun getDetailCharacter(id: Int): CharacterResponse? {
        return try {
            client.get(urlString = "$URL$id").body()
        } catch (e: Exception) {
            Logger.e("Error API SERVICE -> ${e.message}")
            return null
        }
    }

    companion object {
        private const val URL = "/api/characters/"
    }
}