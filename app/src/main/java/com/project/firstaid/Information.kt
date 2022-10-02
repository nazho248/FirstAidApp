package com.project.firstaid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.firstaid.fragments_Information.HomeFragment_info
import com.project.firstaid.fragments_Information.PQRS_Fragment_info
import com.project.firstaid.fragments_Information.adapters.ViewPageAdapterInfo


class Information : AppCompatActivity() {

    val Toolbar: Toolbar? = null
    val ViewPager : ViewPager?= null
    val TabLayout : TabLayout?= null

    //para pasarlos al fragmento
    val firestore = Firebase.firestore.collection("Accidentes")
    var listaPasos = ArrayList<  String  >()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)


        // Obteniendo variables que se pasaron de el fragmento anterior
        val intent = intent
        val position = intent.getIntExtra("posicion", 100)
        val accidente = intent.getStringExtra("accidente")



        //cambios en la interfaz
        val tittlebar = findViewById<TextView>(R.id.titleinfo)
        tittlebar.text = accidente.toString()

        //funcion del boton para volver atrás
        val backBtn = findViewById<LinearLayout>(R.id.backBtn)
        backBtn.setOnClickListener {
            finish()
        }
        setUpTabs()
    }

    private fun setUpTabs(){
        val bundle = Bundle()
        val intent = intent
        val position = intent.getIntExtra("posicion", 100)

        val adapter = ViewPageAdapterInfo(supportFragmentManager)
        adapter.addFragment(HomeFragment_info(position), "¿QUE HACER?" )
        adapter.addFragment(PQRS_Fragment_info(), "PQRS" )

        //Adaptador de las paginas para el visualizador
        val viewPager = findViewById<androidx.viewpager.widget.ViewPager>(R.id.viewPagerInfo)
        val tabs = findViewById<com.google.android.material.tabs.TabLayout>(R.id.tabsInformation)
        tabs.setupWithViewPager(viewPager)
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        //cambiar color de los tabs
        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_question)
        tabs.getTabAt(1)!!.setIcon(R.drawable.triangle_exclamation)
        tabs.getTabAt(1)?.icon?.setTint(getColor(R.color.blancodeshabilitadoApp))



    }


    override fun onResume() {
        super.onResume()
        //change name of the action bar
        val tabs = findViewById<com.google.android.material.tabs.TabLayout>(R.id.tabsInformation)
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