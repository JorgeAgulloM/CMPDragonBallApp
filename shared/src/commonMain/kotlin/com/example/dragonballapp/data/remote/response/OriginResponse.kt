package com.example.dragonballapp.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class OriginResponse(
    val id:Int,
    val name:String,
    val isDestroyed:Boolean,
    val description:String,
    val image:String
)