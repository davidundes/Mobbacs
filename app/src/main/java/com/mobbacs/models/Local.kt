package com.mobbacs.models
import kotlinx.serialization.Serializable


data class Local(
    val id_local: String,
    val nome: String,
    val endereco: String,
    val cep: String,
    val latitude: String,

)