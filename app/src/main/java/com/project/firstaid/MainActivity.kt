package com.project.firstaid

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.firstaid.fragments_main.AccidentesFragment
import com.project.firstaid.fragments_main.EmergenciasFragment
import com.project.firstaid.fragments_main.HomeFragment
import com.project.firstaid.fragments_main.adapters.ViewPageAdapter
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    //declare static global year variable with the value 2020

    val Toolbar: Toolbar? = null
    val ViewPager: ViewPager? = null
    val TabLayout: TabLayout? = null
    val firestore = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       // supportActionBar?.hide()

        //ejemplo de importar de json
        val jsonData = applicationContext.resources.openRawResource(
            applicationContext.resources.getIdentifier(
                "test",
                "raw",
                applicationContext.packageName
            )
        ).bufferedReader().use { it.readText() }

        var outputJsonString = JSONObject(jsonData)
        Log.d("TAG_DATA", ""+outputJsonString.toString())
        val users = outputJsonString.getJSONArray("users") as JSONArray
        println("------------------------------")

        for( i in 0 until users.length()){
            val id = users.getJSONObject(i).getString("id")
            val name = users.getJSONObject(i).getString("name")
            val email = users.getJSONObject(i).getString("email")
            val gender = users.getJSONObject(i).getString("gender")
            val contact = users.getJSONObject(i).getString("contact")

            println("---------------------------")
            println("id: $id")
            println("name: $name")
            println("email: $email")
            println("gender: $gender")
            println("contact: $contact")
        }
        println("------------------------------")


        //importando json de datos de los accidentes
        val jsonDataAccidentes = applicationContext.resources.openRawResource(
            applicationContext.resources.getIdentifier(
                "accidentes",
                "raw",
                applicationContext.packageName
            )
        ).bufferedReader().use { it.readText() }
        outputJsonString = JSONObject(jsonDataAccidentes)
        //Log.d("TAG_DATA", ""+outputJsonString.toString())
        val accidentes = outputJsonString.getJSONArray("Accidentes") as JSONArray


        for( i in 0 until accidentes.length()) {


                var id = accidentes.getJSONObject(i).getString("id").toString()
                //save the "accidente" object in a variable, this contains a "Titulo", "Descripcion, "img" and "Pasos" that are an array of Strings
            var listaPasos = arrayListOf<String>()
            //print the first "Paso" of accidente one by one
            for (j in 0 until accidentes.getJSONObject(i).getJSONArray("Pasos").length()) {
                listaPasos.add(accidentes.getJSONObject(i).getJSONArray("Pasos").getString(j))
            }

            var accidente = hashMapOf(
                    "Titulo" to accidentes.getJSONObject(i).getString("Titulo"),
                    "Descripcion" to accidentes.getJSONObject(i).getString("Descripcion"),
                    "img" to accidentes.getJSONObject(i).getString("img"),
                    //Pasos is an array of Strings
                    "Pasos" to listaPasos
                )

            //save the "accidente" object in the database
            firestore.collection("Accidentes").document(id).set(accidente)
                .addOnSuccessListener {
                    Log.d("TAG_DATA", "DocumentSnapshot successfully written!")
                }
                .addOnFailureListener { e ->
                    Log.w("TAG_DATA", "Error writing document", e)
                }


        }




/*
        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815,
        "Pasos" to listOf("Paso 1", "Paso 2", "Paso 3")
        )

       firestore.collection("Accidentes").document("Accidente1").set(user)
            .addOnSuccessListener {
                Toast.makeText(this, "DocumentSnapshot successfully written!", Toast.LENGTH_SHORT).show()
            }.addOnCanceledListener {
                Toast.makeText(this, "Error writing document", Toast.LENGTH_SHORT).show()
            }

        //print all the data from firestore documentpath "Accidentes" into a toast

        firestore.collection("Accidentes").get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Toast.makeText(this, "${document.id} => ${document.data}", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error getting documents: ", Toast.LENGTH_SHORT).show()
            }
        //OWO

        //read from firestore documentpath "Accidente1" and print in toast
        firestore.collection("Accidentes").document("Accidente1").get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Toast.makeText(this, "DocumentSnapshot data: ${document.data}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "No such document", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "get failed with ", Toast.LENGTH_SHORT).show()
            }

        //read from firestore documentpath "Accidente" and print in toast the "Pregunta" map
        firestore.collection("Accidentes").document("Accidente1").get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Toast.makeText(this, "DocumentSnapshot data: ${document.get("Pregunta")}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "No such document", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "get failed with ", Toast.LENGTH_SHORT).show()
            }*/

        //change color of action bar to white
        supportActionBar?.setBackgroundDrawable(getDrawable(R.color.enfasis))
        setUpTabs()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_exit -> {
                finish()
            }
            R.id.action_references -> {
/*                val intent = Intent(this, ReferencesActivity::class.java)
                startActivity(intent)*/
                Toast.makeText(this, "Aun no las pongo :)", Toast.LENGTH_SHORT).show()
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setUpTabs() {
        val adapter = ViewPageAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(AccidentesFragment(), "Accidentes")
        adapter.addFragment(EmergenciasFragment(), "Emergencias")

        val viewPager = findViewById<androidx.viewpager.widget.ViewPager>(R.id.viewPager)
        viewPager.adapter = adapter
        val tabs = findViewById<com.google.android.material.tabs.TabLayout>(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        /*jump line*/
        tabs.getTabAt(0)?.setIcon(R.drawable.house_solid)
        tabs.getTabAt(1)?.setIcon(R.drawable.triangle_exclamation)


        //change de color of the icons to white
        tabs.getTabAt(2)?.setIcon(R.drawable.phone_solid)

        tabs.getTabAt(1)?.icon?.setTint(getColor(R.color.blancodeshabilitadoApp))
        tabs.getTabAt(2)?.icon?.setTint(getColor(R.color.blancodeshabilitadoApp))
    }

    //change the color of the icons when the tab is selected
    override fun onResume() {
        super.onResume()

        //change name of the action bar

        val tabs = findViewById<com.google.android.material.tabs.TabLayout>(R.id.tabs)
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.icon?.setTint(getColor(R.color.blancoApp))
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon?.setTint(getColor(R.color.blancodeshabilitadoApp))
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                tab.icon?.setTint(getColor(R.color.blancoApp))
            }


        })


    }


}