package com.example.proyectorestapiinmuebles

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface APIService {

    @GET("inmuebles")
    suspend fun getListOfHouses(): Response<List<Inmueble>>

    @DELETE
    suspend fun borrarInmueble(@Url url: String): Response<ResponseBody>

    @POST("inmuebles")
    suspend fun addInmueble(@Body inmueble: Inmueble): Response<Inmueble>
}