package com.example.dragonballapp.di

import com.example.dragonballapp.data.RepositoryImpl
import com.example.dragonballapp.data.remote.ApiService
import com.example.dragonballapp.domain.Repository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {

    single {
        HttpClient {

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        co.touchlab.kermit.Logger.i { "Ktor -> $message"}
                    }
                }
            }

            install(ContentNegotiation) {
                json(
                    json = Json { ignoreUnknownKeys = true },
                    contentType = ContentType.Any
                )
            }
            install(DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "dragonball-api.com"
                }
            }
        }
    }

    factory<Repository> { RepositoryImpl(get()) }
    factoryOf(::ApiService)
}
