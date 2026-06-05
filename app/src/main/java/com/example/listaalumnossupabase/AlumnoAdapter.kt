package com.example.listaalumnossupabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class AlumnoAdapter(
    context: Context,
    private val alumnos: List<Alumno>
) : ArrayAdapter<Alumno>(context, 0, alumnos) {

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {

        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_alumno, parent, false)

        val alumno = alumnos[position]

        val imgFoto = view.findViewById<ImageView>(R.id.imgFoto)
        val txtNombres = view.findViewById<TextView>(R.id.txtNombres)
        val txtCorreo = view.findViewById<TextView>(R.id.txtCorreo)
        val txtTelefono = view.findViewById<TextView>(R.id.txtTelefono)

        txtNombres.text = alumno.nombres
        txtCorreo.text = alumno.correo ?: ""
        txtTelefono.text = alumno.telefono ?: ""

        Glide.with(context)
            .load(alumno.foto)
            .circleCrop()
            .into(imgFoto)

        return view
    }
}