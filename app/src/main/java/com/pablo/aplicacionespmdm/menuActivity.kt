package com.pablo.aplicacionespmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.pablo.aplicacionespmdm.HelloApp.MainActivity
import com.pablo.aplicacionespmdm.IMCApp.imcCalc
import com.pablo.aplicacionespmdm.MessageApp.messageSended

class menuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        btnHelloApp.setOnClickListener{navigateToHelloApp()}

        var btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        btnMessageApp.setOnClickListener{navigateToMessageApp()}

        var btnIMCApp = findViewById<Button>(R.id.btnIMC)
        btnIMCApp.setOnClickListener{navigateToIMCApp()}

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