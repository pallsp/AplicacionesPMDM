package com.pablo.aplicacionespmdm

import com.pablo.aplicacionespmdm.BoardgamesApp.GameCategory

data class Game (val name:String, val category: GameCategory, var isSelected:Boolean = false) {
}