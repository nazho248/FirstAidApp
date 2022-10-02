package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.project.firstaid.Information
import com.project.firstaid.R

internal class AccidentesAdapter(var titulos: List<String>, var iconos: ArrayList<Int>, val context: Context) :
    RecyclerView.Adapter<AccidentesAdapter.ViewHolder>() {


    //declare itemView as a global variable
    lateinit var itemViewGlobal: View

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemTextView: TextView = itemView.findViewById(R.id.tvtxtTitle)
        var ImageView: ImageView = itemView.findViewById(R.id.tvImgIcon)
        //assign itemView to the global variable itemViewGlobal
        init {
            itemViewGlobal = itemView
        }
        //create array with the size of the list of titles
        var cardView: View = itemView.findViewById(R.id.RowAccidente)

    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_accidentes, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = titulos[position]
        val item2 = iconos[position]
        holder.itemTextView.text = item
        //load image resource from link (item2) and set to ImageView by picasso
/*
            Picasso.get().load(item2).into(holder.ImageView)
*/
        //put item2int to imageview, default file loading

        var image = R.drawable.icon100

        if (item2 >= 0 || item2 <= 101) {
            val res: Resources = holder.ImageView.resources
            image = res.getIdentifier("icon$item2", "drawable", "com.project.firstaid")
        }

        //coloca el icono
        holder.ImageView.setImageResource(image)

        val tarjeta = itemViewGlobal.findViewById<View>(R.id.RowAccidente)
        //intent para pasar de actividad al presionar una tarjeta
        tarjeta.setOnClickListener {
            val intent = Intent(context, Information::class.java)

            intent.putExtra("accidente", item)
            //make a toast with the title of the card
            intent.putExtra("posicion", position)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return titulos.size
    }
}