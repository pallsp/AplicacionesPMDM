package com.pablo.tarea2pmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.pablo.tarea2pmdm.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RickMortyListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit

    private lateinit var adapter: CharacterAdapter
    private var numPage: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = getRetrofit()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        binding.cvForward.setOnClickListener {nextSearch()}
        binding.cvBack.setOnClickListener {previousSearch()}
    }

    private fun previousSearch() {
        if(numPage > 1){
            numPage -= 1
            searchPage(numPage)
        }
        else{
            Log.i("Consulta", "Error. No hay páginas anteriores")
            searchPage(numPage)
        }
    }

    private fun nextSearch() {
        if(numPage < 42){
            numPage += 1
            searchPage(numPage)
        }
        else{
            Log.i("Consulta", "Error. No hay páginas posteriores")
            searchPage(numPage)
        }
    }

    private fun initUI() {
        searchAll()
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(query.orEmpty().toInt() <= 824){
                    searchByIdSeveral(query.orEmpty().toInt(),query.orEmpty().toInt()+1, query.orEmpty().toInt()+2)
                    return false
                }
                else if(query.orEmpty().toInt() == 825){
                    searchByIdSeveral(query.orEmpty().toInt(),query.orEmpty().toInt()+1, 1)
                    return false
                }
                else{
                    searchByIdSeveral(query.orEmpty().toInt(),1, 2)
                    return false
                }
            }

            override fun onQueryTextChange(newText: String?) = false

        })

        adapter = CharacterAdapter ()
        binding.rvCharacter.setHasFixedSize(true)
        binding.rvCharacter.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCharacter.adapter = adapter

    }

    private fun searchAll() {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<CharacterDataResponse> =
                retrofit.create(ApiService::class.java).getCharacters()
            if (myResponse.isSuccessful) {
                Log.i("Consulta", "Funciona :)")
                val response: CharacterDataResponse? = myResponse.body()
                if (response != null) {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.characters)
                        binding.progressBar.isVisible = false
                    }
                    numPage = 1
                }
            } else {
                Log.i("Consulta", "No funciona y no sé por qué:(")
                Log.e("Código de Estado", "${myResponse.code()}")
            }

        }

    }

    private fun searchPage(numPage: Int) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<CharacterDataResponse> =
               retrofit.create(ApiService::class.java).getPage(numPage)
            if (myResponse.isSuccessful) {
                Log.i("Consulta", "Funciona :)")
                val response: CharacterDataResponse? = myResponse.body()
                if (response != null) {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.characters)
                        binding.progressBar.isVisible = false
                    }
                }
            } else {
                Log.i("Consulta", "No funciona y no sé por qué:(")
                Log.e("Código de Estado", "${myResponse.code()}")
            }

        }

    }

    private fun searchByIdSeveral(query1: Int, query2: Int, query3: Int) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<List<CharacterItemResponse>> =
                retrofit.create(ApiService::class.java).getCharactersDetails(query1, query2, query3)
            if (myResponse.isSuccessful) {
                Log.i("Consulta", "Funciona :)")
                val response: List<CharacterItemResponse>? = myResponse.body()
                if (response != null) {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        adapter.updateList(response)
                        binding.progressBar.isVisible = false
                    }
                }

            } else {
                Log.i("Consulta", "No funciona :(")
                Log.e("Código de Estado", "${myResponse.code()}")
            }

        }

    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}