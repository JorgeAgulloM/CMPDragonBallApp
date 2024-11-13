package com.example.dragonballapp.data.remote.response

import com.example.dragonballapp.domain.model.OriginPlanetModel
import kotlinx.serialization.Serializable

@Serializable
data class OriginResponse(
    val id:Int,
    val name:String,
    val isDestroyed:Boolean,
    val description:String,
    val image:String
) {
    fun toDomain() = OriginPlanetModel(
        id = id,
        name = name,
        isDestroyed = isDestroyed,
        description = description,
        image = image
    )
}