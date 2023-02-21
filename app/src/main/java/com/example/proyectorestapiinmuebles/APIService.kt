package com.example.proyectorestapiinmuebles

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Url

interface APIService {

    @GET("api/inmuebles")
    suspend fun getListOfHouses(): Response<List<Inmueble>>

    @DELETE("api/inmuebles/{id}")
    suspend fun borrarInmueble(@Path("id") id: Int?): Response<ResponseBody>

    @POST("api/inmuebles")
    suspend fun addInmueble(@Body inmueble: Inmueble): Response<Inmueble>

    @POST("api/inmuebles/{id}")
    suspend fun actualizarInmueble(@Path("id") id: Int?,@Body inmueble: Inmueble): Response<Inmueble>
}