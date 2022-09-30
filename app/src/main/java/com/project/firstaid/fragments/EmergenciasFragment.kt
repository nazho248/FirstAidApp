package com.project.firstaid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.firstaid.Model
import com.project.firstaid.R
import com.project.firstaid.numberAdapter
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class EmergenciasFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

/*    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_emergencias, container, false)
    }*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_emergencias, container, false)

        //colocar programación aquí :3

        val numerosEmergencias = mapOf(
            "Linea de Emergencias " to 123,
            "Bomberos" to 119,
            "Defensa Civil" to 144,
            "Cruz Roja" to 132,
            "Emergencias Medicas" to 125,
            "Policia Metropolitana" to 112,
            "Centro Toxicológico" to 136,
        )

        val arrayList = ArrayList<Model>()
        for (i in numerosEmergencias){
            arrayList.add(Model(i.key, i.value))
        }

        val numberAdapter = numberAdapter(arrayList, requireContext())
        val recyclerView = view.findViewById<RecyclerView>(R.id.recviewnumbers)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = numberAdapter


        return view
    }


}