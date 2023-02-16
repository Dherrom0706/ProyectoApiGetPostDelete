package com.example.proyectorestapiinmuebles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class InmuebleAdapter (var datos: MutableList<Inmueble>):RecyclerView.Adapter<InmuebleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InmuebleViewHolder {
        // inflar la vista para cada elemento del RecyclerView
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.usuarios_esqueleto, parent, false)
        return InmuebleViewHolder(itemView)
    }

    override fun getItemCount() = datos.size

    override fun onBindViewHolder(holder: InmuebleViewHolder, position: Int) {
        // vincular los datos del modelo a la vista
        val inmueble = datos[position]
        holder.id.text = inmueble.idInmueble.toString()
        holder.titulo.text = inmueble.titulo
        holder.precio.text = "$ ${inmueble.precio}"
        holder.ubicacion.text = inmueble.ubicacion
    }


}