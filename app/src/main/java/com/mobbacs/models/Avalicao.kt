package com.mobbacs.models
import kotlinx.serialization.Serializable

@Serializable
data class Avaliacao (
    val id_avaliacao: Int,
    val id_usuario: Int,
    val id_local: Int,
    val nota: Float,
    val data: String
)

