package com.example.proyectorestapiinmuebles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: InmuebleAdapter
    private val inmuebles = mutableListOf<Inmueble>()
    var lista = mutableListOf<Inmueble>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        listaInmuebles()
        listeners()
    }

    private fun listeners() {
        findViewById<Button>(R.id.btnBorrar).setOnClickListener {

        }
    }

    private fun getRetrofitList(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.10.40.51:8080/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun initRecyclerView() {
        adapter = InmuebleAdapter(lista)
        val recyclerView = findViewById<RecyclerView>(R.id.rvInmuebles)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun listaInmuebles(){

        var call =getRetrofitList().create(APIService::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val inmuebles = call.getListOfHouses().body()
                withContext(Dispatchers.Main) {
                    if (inmuebles != null) {
                        adapter.datos.addAll(inmuebles)
                        adapter.notifyDataSetChanged()
                    }
                }
            } catch (e: Exception) {
                Log.e("Inmuebles", "Error al obtener inmuebles", e)
            }
        }

    }

}