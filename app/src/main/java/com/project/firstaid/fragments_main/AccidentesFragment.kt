package com.project.firstaid.fragments_main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.AccidentesAdapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.firstaid.MainActivity
import com.project.firstaid.R


class AccidentesFragment : Fragment() {



    private val titulosAccidentes = ArrayList<String>()
    private val iconosAccidentes = ArrayList<Int>()
    val firestore = Firebase.firestore


    private lateinit var Adapter: AccidentesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_accidentes, container, false)


        val recyclerView = view.findViewById<RecyclerView>(R.id.recTitles)
        Adapter = AccidentesAdapter(titulosAccidentes, iconosAccidentes, requireContext())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = Adapter


        prepareItems()
        //wait until the data is loaded

        return view
    }

    private fun prepareItems() {
        //save all the documents in the list titulosAccidentes from the Accidentes collection
        firestore.collection("Accidentes").get().addOnSuccessListener { result ->
            for (document in result) {
                titulosAccidentes.add(document.getString("Titulo").toString())
            }
            //save all the documents in the list iconosAccidentes from the Accidentes collection
            firestore.collection("Accidentes").get().addOnSuccessListener { result ->
                for (document in result) {
                    if (document.get("img") != null) {
                        iconosAccidentes.add(document.get("img").toString().toInt())
                    }else{
                        iconosAccidentes.add(100)
                    }
                }
                //notify the adapter that the data has changed
                Adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).supportActionBar?.title = "Accidentes"
    }


}