package com.example.proyectorestapiinmuebles

import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {

    @GET("inmuebles")
    suspend fun getListOfHouses(): Response<List<Inmueble>>

    @DELETE
    suspend fun borrarInmueble(): Response<Inmueble>
}