package com.example.listaalumnossupabase

import kotlinx.serialization.Serializable

@Serializable
data class Alumno(
    val id: Long,
    val foto: String? = null,
    val nombres: String,
    val correo: String? = null,
    val paralelo: String,
    val telefono: String? = null
)