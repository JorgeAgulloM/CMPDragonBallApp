package com.example.dragonballapp.data

import com.example.dragonballapp.data.remote.ApiService
import com.example.dragonballapp.domain.Repository
import com.example.dragonballapp.domain.model.CharacterDetailModel
import com.example.dragonballapp.domain.model.CharacterModel

class RepositoryImpl(private val api: ApiService): Repository {
    override suspend fun getCharacters(): List<CharacterModel> = api
        .getAllCharacters().items.map { it.toDomain() }

    override suspend fun getDetailCharacter(id: Int): CharacterDetailModel? =
        api.getDetailCharacter(id)?.toDetailDomain()

}
