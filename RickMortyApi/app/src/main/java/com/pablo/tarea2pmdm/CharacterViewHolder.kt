package com.pablo.tarea2pmdm

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.pablo.tarea2pmdm.databinding.ItemCharacterBinding
import com.squareup.picasso.Picasso

class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemCharacterBinding.bind(view)

    fun bind(characterItemResponse: CharacterItemResponse) {
        binding.tvCharacterName.text = characterItemResponse.name
        binding.tvId.text = "ID: "+characterItemResponse.characterId.toString()
        binding.tvStatus.text = "ESTADO: "+characterItemResponse.status
        binding.tvLocation.text = "LOCALIZACIÓN: "+characterItemResponse.characterLocation.nameLocation
        binding.tvSpecies.text = "ESPECIE: "+characterItemResponse.species
        Picasso.get().load(characterItemResponse.characterImage).into(binding.ivCharacter)
        /*binding.root.setOnClickListener {
            navigateToDetailActivity(characterItemResponse.characterId)
        }*/
    }
}
