package com.example.dragonballapp.domain

import com.example.dragonballapp.domain.model.CharacterModel

interface Repository {

    suspend fun getCharacters(): List<CharacterModel>
}