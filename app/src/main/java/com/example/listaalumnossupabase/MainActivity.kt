package com.example.listaalumnossupabase

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var listaAlumnos: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaAlumnos = findViewById(R.id.listaAlumnos)

        cargarAlumnos()
    }

    private fun cargarAlumnos() {

        lifecycleScope.launch {

            try {

                val alumnos = supabase
                    .from("alumnos")
                    .select()
                    .decodeList<Alumno>()

                Log.d("SUPABASE", "Cantidad alumnos: ${alumnos.size}")

                val adapter = AlumnoAdapter(
                    this@MainActivity,
                    alumnos
                )

                listaAlumnos.adapter = adapter

            } catch (e: Exception) {

                Log.e(
                    "SUPABASE",
                    "ERROR: ${e.message}",
                    e
                )
            }
        }
    }
}