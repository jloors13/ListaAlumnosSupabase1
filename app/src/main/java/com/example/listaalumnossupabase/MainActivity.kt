package com.example.listaalumnossupabase

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
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

        val spnSemestre = findViewById<Spinner>(R.id.spnSemestre)
        val spnMateria = findViewById<Spinner>(R.id.spnMateria)

        val semestres = listOf(
            "Primero",
            "Segundo",
            "Tercero",
            "Cuarto",
            "Quinto",
            "Sexto",
            "Séptimo",
            "Octavo"
        )

        spnSemestre.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            semestres
        )

        spnSemestre.setSelection(5)

        spnSemestre.onItemSelectedListener =
            object : android.widget.AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: android.widget.AdapterView<*>?,
                    view: android.view.View?,
                    position: Int,
                    id: Long
                ) {

                    val nivel = position + 1

                    cargarMaterias(
                        nivel = nivel,
                        spnMateria = spnMateria
                    )

                    cargarAlumnos(nivel)
                }

                override fun onNothingSelected(parent: android.widget.AdapterView<*>?) {
                }
            }
    }

    private fun cargarAlumnos(nivel: Int) {

        lifecycleScope.launch {

            try {

                if (nivel != 6) {

                    listaAlumnos.adapter = AlumnoAdapter(
                        this@MainActivity,
                        emptyList()
                    )

                    return@launch
                }

                val alumnos = supabase
                    .from("alumnos")
                    .select()
                    .decodeList<Alumno>()
                    .sortedBy { it.nombres }

                listaAlumnos.adapter = AlumnoAdapter(
                    this@MainActivity,
                    alumnos
                )

                Log.d(
                    "SUPABASE",
                    "Alumnos cargados: ${alumnos.size}"
                )

            } catch (e: Exception) {

                Log.e(
                    "SUPABASE",
                    "ERROR: ${e.message}",
                    e
                )
            }
        }
    }

    private fun cargarMaterias(
        nivel: Int,
        spnMateria: Spinner
    ) {

        lifecycleScope.launch {

            try {

                val materias = supabase
                    .from("materias")
                    .select()
                    .decodeList<Materia>()

                val materiasFiltradas =
                    materias.filter {
                        it.nivel == nivel
                    }

                val nombres =
                    materiasFiltradas.mapNotNull {
                        it.nombre
                    }

                spnMateria.adapter = ArrayAdapter(
                    this@MainActivity,
                    android.R.layout.simple_spinner_dropdown_item,
                    nombres
                )

            } catch (e: Exception) {

                Log.e(
                    "SUPABASE",
                    "Error cargando materias: ${e.message}",
                    e
                )
            }
        }
    }
}