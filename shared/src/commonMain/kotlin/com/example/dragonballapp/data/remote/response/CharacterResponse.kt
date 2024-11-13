package com.example.dragonballapp.data.remote.response

import com.example.dragonballapp.domain.model.CharacterDetailModel
import com.example.dragonballapp.domain.model.CharacterModel
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val id: Int,
    val name: String,
    val ki: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String,
    val originPlanet: OriginResponse? = null,
    val transformations: List<TransformationResponse> = emptyList()
) {
    fun toDomain(): CharacterModel = CharacterModel(
        id = id,
        name = name,
        ki = ki,
        race = race,
        gender = gender,
        description = description,
        image = image
    )

    fun toDetailDomain(): CharacterDetailModel? {
        if (originPlanet == null) return null

        return CharacterDetailModel(
            characterModel = toDomain(),
            originPlanet = originPlanet.toDomain(),
            transformations = transformations.map { it.toDomain() }
        )
    }
}
