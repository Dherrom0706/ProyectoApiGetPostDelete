package com.example.proyectorestapiinmuebles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.*

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
        findViewById<FloatingActionButton>(R.id.btn_add).setOnClickListener {
            var inmueble = Inmueble(
                "Mi casa",
                12F,
                "Hola",
                200,
                120,
                "Ubicacion",
                "Ejido",
                "2010-10-10",
                1,
                1,
                null)
            var call =getRetrofitList().create(APIService::class.java)

            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val inmuebles = call.addInmueble(inmueble).body()
                    withContext(Dispatchers.Main) {
                        if (inmuebles != null) {
                            adapter.datos.add(inmuebles)
                            adapter.notifyDataSetChanged()
                        }
                    }
                } catch (e: Exception) {
                    Log.e("Inmuebles", "Error al obtener inmuebles", e)
                }
            }

        }

        findViewById<Button>(R.id.btnBorrar).setOnClickListener {
            var inmueble = Inmueble(
                "Mi casa",
                12F,
                "Hola",
                200,
                120,
                "Ubicacion",
                "Ejido",
                "2010-10-10",
                1,
                1,
                null)
            var call =getRetrofitList().create(APIService::class.java)

            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val inmuebles = call.addInmueble(inmueble).body()
                    withContext(Dispatchers.Main) {
                        if (inmuebles != null) {
                            adapter.datos.add(inmuebles)
                            adapter.notifyDataSetChanged()
                        }
                    }
                } catch (e: Exception) {
                    Log.e("Inmuebles", "Error al obtener inmuebles", e)
                }
            }
        }
    }

    private fun getRetrofitList(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.10.30.84:8080/api/")
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