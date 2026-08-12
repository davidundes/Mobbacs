package com.mobbacs.models
import kotlinx.serialization.Serializable

@Serializable
data class Local(
    val id_local: Int,
    val nome: String,
    val endereco: String,
    val cep: String,
    val latitude: String,
    val longitude: String,
    val telofone: String,
    val horario: String
)