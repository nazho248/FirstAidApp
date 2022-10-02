package com.project.firstaid.fragments_Information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.firstaid.R
import com.project.firstaid.fragments_Information.adapters.InformationAdapter


class HomeFragment_info(bundle: Int) : Fragment() {

    var posGlobal = bundle

    private var listaPasos = ArrayList<  String  >()
    val firestore = Firebase.firestore.collection("Accidentes")
    private lateinit var Adapter: InformationAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home_info, container, false)
        //colocar programación aquí :3
        //intent data
        if (posGlobal != null) {
            var data = arguments
            var test = data?.getString("test")
            var pos = data?.getString("posicion")

            println("-----------------------------------------------------------------------")
            println("$posGlobal BIEEEEN IMPRIMISTE EL NUMERO QUE NECESITABAS >:C")
            println("-----------------------------------------------------------------------")
        }


        //posGlobal = pos!!.toInt()
        //Toast.makeText(requireContext(), pos?.get(0).toString() , Toast.LENGTH_SHORT).show()
        //getcontentdescription of the first tab





        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_steps)
        Adapter = InformationAdapter(listaPasos, this.requireContext())
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        recyclerView.adapter = Adapter
      prepareitems()



        //modificando interfaz
        val image = view.findViewById<ImageView>(R.id.fragment_presentation_image)
        //image.setImageResource(R.drawable.citywall)
        var descriptionAccident = view.findViewById<TextView>(R.id.fragment_presentation_title)

        //descriptionAccident.text = test


        return view
    }

    public fun prepareitems() {

        firestore.document((posGlobal+1).toString()).get().addOnSuccessListener { result ->
            if (result.get("Pasos") != null) {
                for (document in result.get("Pasos") as ArrayList<String>) {
                    listaPasos.add(document)
                }
        }


            Adapter.notifyDataSetChanged()
        }
/*        for (i in 1..3){
            listaPasos.add("Paso $i  Lorem IPSUM dolor afj haklfasf kjahkljf asdsa ")
        }
        println(listaPasos)*/

        //listaPasos = pasos as ArrayList<String>
    }


    override fun onResume() {
        super.onResume()
    }


}