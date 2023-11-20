package com.pablo.aplicacionespmdm.ColorsApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pablo.aplicacionespmdm.R

class ColorsAdapter(private val verticalBars: List<VerticalBar>): RecyclerView.Adapter<ColorsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
        return ColorsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ColorsViewHolder, position: Int) {
        holder.render(verticalBars[position])
    }

    override fun getItemCount() = verticalBars.size
}