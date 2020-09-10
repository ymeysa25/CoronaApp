package com.example.coronaapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions



class ListAdapter(val listCorona: ArrayList<Corona>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
        return ListViewHolder(view)
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val corona = listCorona[position]
        Glide.with(holder.itemView.context)
            .load(corona.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = corona.name
        holder.tvTotal.text = "Total Kasus : " + corona.total.toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)

            intent.putExtra("position", position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listCorona.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvTotal: TextView = itemView.findViewById(R.id.tv_item_total)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}