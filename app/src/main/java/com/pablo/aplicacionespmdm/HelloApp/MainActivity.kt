package com.pablo.aplicacionespmdm.HelloApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.pablo.aplicacionespmdm.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_send = findViewById<Button>(R.id.btn_send)
        var userText = findViewById<EditText>(R.id.etName)

        btn_send.setOnClickListener{
            var name = userText.text.toString()
            if(name.isNotEmpty()){
                var textIntent =Intent(this, second_activity::class.java)
                textIntent.putExtra("extra_name",name)
                startActivity(textIntent)
            }
        }
    }
}