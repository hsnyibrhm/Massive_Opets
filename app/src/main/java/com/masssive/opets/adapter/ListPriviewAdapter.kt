package com.masssive.opets.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masssive.opets.R
import com.masssive.opets.model.Preview

class ListPriviewAdapter(private val listPreview: ArrayList<Preview>) : RecyclerView.Adapter<ListPriviewAdapter.ListViewHolder>(){
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_pv: ImageView = itemView.findViewById(R.id.img_prev)
        val tvKEt: TextView = itemView.findViewById(R.id.tv_tgl)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.preview_item, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listPreview.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (foto, deskripsi, tanggal) = listPreview[position]
        holder.img_pv.setImageResource(foto)
        holder.tvKEt.text = tanggal

    }

}