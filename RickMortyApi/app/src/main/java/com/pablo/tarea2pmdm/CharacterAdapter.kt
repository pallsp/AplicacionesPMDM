package com.pablo.tarea2pmdm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class CharacterAdapter(var charactersList: List<CharacterItemResponse> = emptyList()) : RecyclerView.Adapter<CharacterViewHolder>() {

    fun updateList(list: List<CharacterItemResponse>) {
        charactersList = list
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        )
    }
    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(charactersList[position])

    }
    override fun getItemCount() = charactersList.size
}
