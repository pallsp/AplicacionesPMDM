package com.pablo.aplicacionespmdm

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.pablo.aplicacionespmdm.BoardgamesApp.BoardgameActivity
import com.pablo.aplicacionespmdm.ColorsApp.ColorsActivity
import com.pablo.aplicacionespmdm.HelloApp.MainActivity
import com.pablo.aplicacionespmdm.IMCApp.imcCalc
import com.pablo.aplicacionespmdm.MessageApp.messageSended
import com.pablo.aplicacionespmdm.SuperheroApp.SuperheroListActivity

class menuActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        btnHelloApp.setOnClickListener{navigateToHelloApp()}

        var btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        btnMessageApp.setOnClickListener{navigateToMessageApp()}

        var btnIMCApp = findViewById<Button>(R.id.btnIMC)
        btnIMCApp.setOnClickListener{navigateToIMCApp()}

        var btnBoardApp = findViewById<Button>(R.id.btnBoardgame)
        btnBoardApp.setOnClickListener {navigateToBoardApp()}

        var btnColorApp = findViewById<Button>(R.id.btnColorsApp)
        btnColorApp.setOnClickListener {navigateToColorApp()}

        var btnSuperheroApp = findViewById<Button>(R.id.btnSuperheroApp)
        btnSuperheroApp.setOnClickListener {navigateToSuperheroApp()}

    }

    private fun navigateToSuperheroApp() {
        var intent = Intent(this, SuperheroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToColorApp() {
        var intent = Intent(this, ColorsActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToBoardApp() {
        var intent = Intent(this,BoardgameActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp() {
        var intent = Intent(this, imcCalc::class.java)
        startActivity(intent)
    }

    private fun navigateToMessageApp() {
        var intent = Intent(this, messageSended::class.java)
        startActivity(intent)
    }

    private fun navigateToHelloApp() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}