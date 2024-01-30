package com.pablo.aplicacionespmdm.ColorsApp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.pablo.aplicacionespmdm.R

class ColorsViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val tvVerticalBar: TextView = view.findViewById(R.id.tvColorName)
    private val cvVerticalBar: CardView = view.findViewById(R.id.cvColorContainer)
    fun render(verticalBar: VerticalBar){
        tvVerticalBar.text = verticalBar.label
        cvVerticalBar.setCardBackgroundColor(verticalBar.colorSelected)
    }
}