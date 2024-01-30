package com.pablo.aplicacionespmdm.MessageApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.pablo.aplicacionespmdm.R

class messageSended : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_sended)

        var btn_send = findViewById<Button>(R.id.btn_send)
        var userText = findViewById<EditText>(R.id.etName)
        var textMostrar = findViewById<TextView>(R.id.otherText)
        var repRecibida = findViewById<TextView>(R.id.textName2)
        var otroContenido: String = intent.extras?.getString("other_content").orEmpty()
        if(otroContenido.isNotEmpty()){
            repRecibida.text="Reply Received!"
        }
        textMostrar.text="$otroContenido"

        btn_send.setOnClickListener{
            var name = userText.text.toString()
            if(name.isNotEmpty()){
                var textIntent = Intent(this, messageReceived::class.java)
                textIntent.putExtra("extra_name",name)
                startActivity(textIntent)
            }
        }
    }
}