package com.project.firstaid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class PautasBasicas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //hide toolbar
        supportActionBar?.hide()
        setContentView(R.layout.activity_pautas_basicas)

        //funcion del boton para volver atrás
        val backBtn = findViewById<LinearLayout>(R.id.backBtn)
        backBtn.setOnClickListener {
            finish()
        }

    }
}