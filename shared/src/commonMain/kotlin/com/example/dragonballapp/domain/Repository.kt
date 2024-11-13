package com.example.dragonballapp.domain

import com.example.dragonballapp.domain.model.CharacterDetailModel
import com.example.dragonballapp.domain.model.CharacterModel

interface Repository {
    suspend fun getCharacters(): List<CharacterModel>
    suspend fun getDetailCharacter(id: Int): CharacterDetailModel?
}
