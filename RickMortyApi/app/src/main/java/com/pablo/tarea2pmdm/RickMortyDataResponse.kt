package com.pablo.tarea2pmdm

import com.google.gson.annotations.SerializedName

data class CharacterDataResponse (
    @SerializedName("results") val characters: List<CharacterItemResponse>,
)
data class CharacterItemResponse(
    @SerializedName("id") val characterId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("image") val characterImage: String,
    @SerializedName("location") val characterLocation: LocationResponse
)
data class LocationResponse(
    @SerializedName("name") val nameLocation: String
)

