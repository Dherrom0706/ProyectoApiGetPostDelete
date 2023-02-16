package com.example.proyectorestapiinmuebles

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InmuebleViewHolder (vista: View): RecyclerView.ViewHolder(vista){

    val titulo: TextView = itemView.findViewById(R.id.tvTitulo)
    val precio: TextView = itemView.findViewById(R.id.tvPrecio)
    val ubicacion: TextView = itemView.findViewById(R.id.tvUbi)
    val id: TextView = itemView.findViewById(R.id.tvId)

}