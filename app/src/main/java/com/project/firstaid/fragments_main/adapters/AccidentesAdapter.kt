package com.example.myapplication

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.project.firstaid.R

internal class AccidentesAdapter(var titulos: List<String>, var iconos: ArrayList<Int>) :
    RecyclerView.Adapter<AccidentesAdapter.viewHolder>() {

    internal inner class viewHolder(view: View) : RecyclerView.ViewHolder(view) {

        lateinit var countryList: Array<String>
        lateinit var flags: IntArray
        var itemTextView: TextView = view.findViewById(R.id.tvtxtTitle)
        var ImageView: ImageView = view.findViewById(R.id.tvImgIcon)
        //create array with the size of the list of titles
        var cardView: View = view.findViewById(R.id.RowAccidente)

        

    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_accidentes, parent, false)
        return viewHolder(itemView)
    }
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = titulos[position]
        val item2 = iconos[position]
        holder.itemTextView.text = item
        //load image resource from link (item2) and set to ImageView by picasso
/*
            Picasso.get().load(item2).into(holder.ImageView)
*/
            //put item2int to imageview, default file loading

        var image = R.drawable.icon5

        if (item2 >=0 || item2 <= 9){
            val res: Resources = holder.ImageView.resources
            image = res.getIdentifier("icon$item2", "drawable", "com.project.firstaid")

        }
            holder.ImageView.setImageResource(image)


    }
    override fun getItemCount(): Int {
        return titulos.size
    }
}