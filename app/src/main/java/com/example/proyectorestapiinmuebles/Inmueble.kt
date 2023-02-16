package com.example.proyectorestapiinmuebles

import java.util.Date

data class Inmueble(
    var titulo: String,
    var precio: Float,
    var descripcion:String,
    var metrosConstruidos:Int,
    var metrosUtiles:Int,
    var ubicacion: String,
    var zona: String,
    var fechaPublicacion: Date,
    var habitaciones: Int,
    var bannos: Int,
    var idInmueble: Int
    )
