package com.mobbacs.models

import kotlinx.serialization.Serializable

//Modelo do usario que será usado para criação

@Serializable
data class User(
    val id_usuario: Int,
    val nome: String,
    val email: String? = null,
    val senha: String? = null,
    val cpf: String? = null)
