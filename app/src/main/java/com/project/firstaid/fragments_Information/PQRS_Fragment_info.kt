package com.project.firstaid.fragments_Information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.firstaid.R
import com.project.firstaid.fragments_Information.adapters.RecycleAdapter
import java.time.temporal.ChronoUnit


class PQRS_Fragment_info(position: Int) : Fragment() {

    val listData: MutableList<ParentData> = ArrayList()
    val posGlobal: Int = position + 1 //posicion del accidente

    val firestore = Firebase.firestore.collection("Accidentes")

    //variable para guardar el conjunto de preguntas y respuestas


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home_pqrs, container, false)
        //colocar programación aquí :3

        firestore.document((posGlobal).toString()).get().addOnSuccessListener { result ->
            //declare preguntas and respuestas as arraylist void
            var preguntas: ArrayList<String> = ArrayList()
            var respuestas: ArrayList<String> = ArrayList()
            var parentData: ArrayList<String> = ArrayList() //todos los titulos
            var childData: ArrayList<MutableList<ChildData>> =
                ArrayList() // lista de child data, que contiene cada uno una lista de respuestas
            if (result.get("Preguntas") != null) {
                preguntas = result.get("Preguntas") as ArrayList<String>
                respuestas = result.get("Respuestas") as ArrayList<String>

                parentData = preguntas
                //llenar child data con las respuestas, si contiene /n se separa en lineas
                //recorrer las respuestas
                for (i in 0 until respuestas.size) {
                    var childData2: MutableList<ChildData> = ArrayList() //un child data
                    var respuesta = respuestas[i]
                    //si contiene /n, separar por /n
                    if (respuesta.contains("/n")) {
                        var respuestas2 = respuesta.split("/n")
                        for (j in 0 until respuestas2.size) {
                            childData2.add(ChildData(respuestas2[j]))
                        }
                    } else {
                        childData2.add(ChildData(respuesta))
                    }
                    childData.add(childData2)
                }
            } else {
/*                Toast.makeText(
                    requireContext(),
                    "No hay preguntas y respuestas disponibles",
                    Toast.LENGTH_SHORT
                ).show()*/
                // set text to the element textview "noInfoAvailable" to "No hay preguntas y respuestas disponibles"
                view.findViewById<TextView>(R.id.noInfoAvailable).text = "No hay información para mostrar"
            }

            for (i in 0 until parentData.size) {
                listData.add(ParentData(parentTitle = parentData[i], subList = childData[i]))
            }

            val recyclerView = view.findViewById<RecyclerView>(R.id.exRecycle)
            val adapter = RecycleAdapter(requireContext(), listData)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

        }

/*        val parentData: Array<String> = arrayOf("AUSILIOOO", "Sintomas", "Llamo la poli?", "xd") //titulos de las preguntas
        val childDataData1: MutableList<ChildData> = mutableListOf(ChildData("a"),ChildData("xd"),ChildData("jaja"),ChildData("OwO"))
        val childDataData2: MutableList<ChildData> = mutableListOf(ChildData("b"), ChildData("cagar mucho"), ChildData("ver feo"))
        val childDataData3: MutableList<ChildData> = mutableListOf(ChildData("c la poli?"), ChildData("No"))

        val parentObj1 = ParentData(parentTitle = parentData[0], subList = childDataData1)
        val parentObj2 = ParentData(parentTitle = parentData[1], subList = childDataData2)
        val parentObj3 = ParentData(parentTitle = parentData[2])
        val parentObj4 = ParentData(parentTitle = parentData[1], subList = childDataData3)

        listData.add(parentObj1)
        listData.add(parentObj2)
        listData.add(parentObj3)
        listData.add(parentObj4)*/

//        val recyclerView = view.findViewById<RecyclerView>(R.id.exRecycle)
//        val adapter = RecycleAdapter(requireContext(), listData)
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        return view

    }


}