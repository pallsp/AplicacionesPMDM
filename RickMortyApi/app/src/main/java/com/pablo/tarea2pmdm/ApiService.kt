package com.pablo.tarea2pmdm

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getPage(@Query("page") page:Int):Response<CharacterDataResponse>

    @GET("character")
    suspend fun getCharacters():Response<CharacterDataResponse>

    @GET("character/{id1},{id2},{id3}")
    suspend fun getCharactersDetails(@Path("id1") characterId1:Int,@Path("id2") characterId2:Int, @Path("id3") characterId3:Int ):Response<List<CharacterItemResponse>>
}

