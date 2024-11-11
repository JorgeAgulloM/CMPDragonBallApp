package com.example.dragonballapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterModel(
    val id: Int,
    val name: String,
    val ki: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String,
    //val originPlanet: OriginResponse? = null,
    //val transformations: List<TransformationResponse> = emptyList()
)