package com.project.firstaid

import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.firstaid.fragments_main.AccidentesFragment
import com.project.firstaid.fragments_main.EmergenciasFragment
import com.project.firstaid.fragments_main.Home2Fragment
import com.project.firstaid.fragments_main.adapters.ViewPageAdapter

class MainActivity : AppCompatActivity() {

    val Toolbar: Toolbar? = null
    val ViewPager : ViewPager?= null
    val TabLayout : TabLayout?= null
    val firestore = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        supportActionBar?.hide()
*/

        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815
        )

/*        firestore.collection("Accidentes").document("Accidente1").set(user)
            .addOnSuccessListener {
                Toast.makeText(this, "DocumentSnapshot successfully written!", Toast.LENGTH_SHORT).show()
            }.addOnCanceledListener {
                Toast.makeText(this, "Error writing document", Toast.LENGTH_SHORT).show()
            }*/

        //print all the data from firestore documentpath "Accidentes" into a toast
/*
        firestore.collection("Accidentes").get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Toast.makeText(this, "${document.id} => ${document.data}", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error getting documents: ", Toast.LENGTH_SHORT).show()
            }
*/

        //OWO

        //read from firestore documentpath "Accidente1" and print in toast
/*        firestore.collection("Accidentes").document("Accidente1").get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Toast.makeText(this, "DocumentSnapshot data: ${document.data}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "No such document", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "get failed with ", Toast.LENGTH_SHORT).show()
            }*/

        //read from firestore documentpath "Accidente" and print in toast the "Pregunta" map
/*        firestore.collection("Accidentes").document("Accidente1").get()
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





    private fun setUpTabs(){
        val adapter = ViewPageAdapter(supportFragmentManager)
        adapter.addFragment(Home2Fragment(), "Home")
        adapter.addFragment(AccidentesFragment(), "Accidentes")
        adapter.addFragment(EmergenciasFragment(), "Emergencias")

        val viewPager = findViewById<androidx.viewpager.widget.ViewPager>(R.id.viewPager)
        viewPager.adapter = adapter
        val tabs = findViewById<com.google.android.material.tabs.TabLayout>(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        /*jump line*/
        tabs.getTabAt(0)?.setIcon(R.drawable.house_solid)
        tabs.getTabAt(1)?.setIcon(R.drawable.triangle_exclamation)
        tabs.getTabAt(2)?.setIcon(R.drawable.phone_solid)

    }
}