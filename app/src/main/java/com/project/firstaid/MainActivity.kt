package com.project.firstaid

import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.project.firstaid.fragments.AccidentesFragment
import com.project.firstaid.fragments.EmergenciasFragment
import com.project.firstaid.fragments.Home2Fragment
import com.project.firstaid.fragments.adapters.ViewPageAdapter

class MainActivity : AppCompatActivity() {

    val Toolbar: Toolbar? = null
    val ViewPager : ViewPager?= null
    val TabLayout : TabLayout?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        supportActionBar?.hide()
*/








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