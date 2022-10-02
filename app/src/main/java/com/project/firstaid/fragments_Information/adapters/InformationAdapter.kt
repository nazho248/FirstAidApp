package com.project.firstaid.fragments_Information.adapters


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

internal class InformationAdapter(var pasos: List<String>, val context: Context) :
    RecyclerView.Adapter<InformationAdapter.ViewHolder>() {


    //declare itemView as a global variable
    lateinit var itemViewGlobalInfo: View

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var countryList: Array<String>
        lateinit var flags: IntArray
        var itemTextView: TextView = itemView.findViewById(R.id.rvStepInfo)
        var number: TextView = itemView.findViewById(R.id.rvNumberStep)
        var cardView: View = itemView.findViewById(R.id.RowInfoStep)

    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_info_step, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pasos[position]
        holder.itemTextView.text = item
        holder.number.text = (position + 1).toString()


    }

    override fun getItemCount(): Int {
        return pasos.size
    }
}