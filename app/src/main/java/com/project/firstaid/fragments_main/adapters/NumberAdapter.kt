package com.project.firstaid

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class numberAdapter (val ArryList: ArrayList<Model>, val context:Context):
    RecyclerView.Adapter<numberAdapter.viewHolder>() {

    inner class viewHolder( itemView:View) : RecyclerView.ViewHolder(itemView) {


        fun bindItems(model: Model){
            //get item from layout
            val nombreContacto = itemView.findViewById<TextView>(R.id.tvNombreContacto)
            val numeroContacto = itemView.findViewById<TextView>(R.id.tvTelefonoContacto)

            //set item to layout
            nombreContacto.text = model.nombreContacto
            numeroContacto.text = model.numeroContacto.toString()

            //add functionality to buttons
            //when pressed btn with id btnagregar, add to contacts a number
            val btnAgregar = itemView.findViewById<Button>(R.id.btnagregar)
            btnAgregar.setOnClickListener {
                //add number to contacts
                val intent = Intent(Intent.ACTION_INSERT)
                intent.type = "vnd.android.cursor.dir/contact"
                intent.putExtra("name", nombreContacto.text)
                intent.putExtra("phone", numeroContacto.text)
                context.startActivity(intent)

            }

            //when pressed btn with id btnllamar, call to number
            val btnLlamar = itemView.findViewById<Button>(R.id.btnllamar)
            btnLlamar.setOnClickListener {
                //call to number
                val Intent = Intent(Intent.ACTION_DIAL)
                Intent.data = Uri.parse("tel:${model.numeroContacto}")
                context.startActivity(Intent)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.numbersrows , parent, false)
        return viewHolder(v)
    }

    override fun getItemCount(): Int {
        return ArryList.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bindItems(ArryList[position])
    }



}