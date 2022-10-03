package com.project.firstaid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView

class BotiquinPAux : AppCompatActivity() {

    val ListView : ListView? = null
    val ArrayAdapter : ArrayAdapter<String>? = null

    val recursos = arrayOf(
        "Alcohol al 70%",
        "Agua oxigenada",
        "Mercurio cromo",
        "Suero fisiológico o solución salina normal",
        "Yodo",
        "Bactroderm",
        "Yodopovidona",
        "Isodine",
        "Yovidona",
        "Wescodine",
        "Prepodine",
        "Jabón"
    )

    val materialCuracion = arrayOf(
        "Algodón",
        "Gasa",
        "Aplicadores o copitos",
        "Bajalenguas",
        "Vendas",
        "Curitas",
        "Esparadrapo"
    )

    val otrosElementos = arrayOf(
        "Pinza",
        "Tijeras",
        "Cuchillas",
        "Navajas",
        "Termómetros",
        "Ganchos de nodriza",
        "Goteros",
        "Torniquete"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeros_aux)

        //hide toolbar
        supportActionBar?.hide()

        //funcion del boton para volver atrás
        val backBtn = findViewById<LinearLayout>(R.id.backBtn)
        backBtn.setOnClickListener {
            finish()
        }


        //listview recursos
        val listView = findViewById<ListView>(R.id.listViewRecursos)
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_multiple_choice, recursos)
        listView.adapter = adapter

        //listview material de curacion
        val listView2 = findViewById<ListView>(R.id.listViewMaterialCuaracion)
        val adapter2 = ArrayAdapter(this,
            android.R.layout.simple_list_item_multiple_choice, materialCuracion)
        listView2.adapter = adapter2

        //listview otros elementos
        val listView3 = findViewById<ListView>(R.id.listViewOtrosElementos)
        val adapter3 = ArrayAdapter(this,
            android.R.layout.simple_list_item_multiple_choice, otrosElementos)
        listView3.adapter = adapter3

    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        return super.onOptionsItemSelected(item)
    }


}