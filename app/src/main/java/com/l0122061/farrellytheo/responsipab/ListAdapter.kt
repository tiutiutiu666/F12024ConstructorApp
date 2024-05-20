package com.l0122061.farrellytheo.responsipab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val listCircuit: ArrayList<Circuit>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    var onItemClick : ((Circuit) -> Unit)? = null

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listCircuit.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val circuit = listCircuit[position]
        holder.imgPhoto.setImageResource(circuit.img)
        holder.tvName.text = circuit.name
        holder.tvDescription.text = circuit.desc

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(circuit)
        }
    }
}