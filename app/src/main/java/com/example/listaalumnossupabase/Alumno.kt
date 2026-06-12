package com.example.listaalumnossupabase

import kotlinx.serialization.Serializable

@Serializable
data class Alumno(
    val id: Int,
    val foto: String,
    val nombres: String,
    val correo: String,
    val paralelo: String,
    val telefono: String
)