package com.project.firstaid.fragments_Information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.firstaid.R
import com.project.firstaid.fragments_Information.adapters.InformationAdapter
import com.project.firstaid.fragments_Information.adapters.RecycleAdapter


class PQRS_Fragment_info : Fragment() {

    val listData : MutableList<ParentData> = ArrayList()


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

        val parentData: Array<String> = arrayOf("AUSILIOOO", "Sintomas", "Llamo la poli?", "xd")
        val childDataData1: MutableList<ChildData> = mutableListOf(ChildData("AUSILIOOO"),ChildData("xd"),ChildData("jaja"),ChildData("OwO"))
        val childDataData2: MutableList<ChildData> = mutableListOf(ChildData("Sintomas"), ChildData("cagar mucho"), ChildData("ver feo"))
        val childDataData3: MutableList<ChildData> = mutableListOf(ChildData("Llamo la poli?"), ChildData("No"))

        val parentObj1 = ParentData(parentTitle = parentData[0], subList = childDataData1)
        val parentObj2 = ParentData(parentTitle = parentData[1], subList = childDataData2)
        val parentObj3 = ParentData(parentTitle = parentData[2])
        val parentObj4 = ParentData(parentTitle = parentData[1], subList = childDataData3)

        listData.add(parentObj1)
        listData.add(parentObj2)
        listData.add(parentObj3)
        listData.add(parentObj4)

        val recyclerView = view.findViewById<RecyclerView>(R.id.exRecycle)
        val adapter = RecycleAdapter(requireContext(), listData)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())




        return view

    }



 }