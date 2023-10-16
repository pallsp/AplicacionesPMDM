package com.pablo.aplicacionespmdm.MessageApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.pablo.aplicacionespmdm.R

class messageReceived : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_received)

        var btn_send2 = findViewById<Button>(R.id.btn_send2)
        var mens=findViewById<TextView>(R.id.otherText2)
        var textUser = findViewById<EditText>(R.id.etName2)
        var contenido: String = intent.extras?.getString("extra_name").orEmpty()

        mens.text="$contenido"

        btn_send2.setOnClickListener{
            var mensaje = textUser.text.toString()
            if(mensaje.isNotEmpty()){
                var intentText = Intent(this, messageSended::class.java)
                intentText.putExtra("other_content",mensaje)
                startActivity(intentText)
            }
        }
    }
}