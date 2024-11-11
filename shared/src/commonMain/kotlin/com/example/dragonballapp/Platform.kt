package com.example.dragonballapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform