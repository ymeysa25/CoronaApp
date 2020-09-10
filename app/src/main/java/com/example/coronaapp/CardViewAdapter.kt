package com.example.coronaapp


import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.request.RequestOptions

class CardViewAdapter(private val listCorona: ArrayList<Corona>) : RecyclerView.Adapter<CardViewAdapter.CardViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_cardview, parent, false)
        return CardViewViewHolder(view)

    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val corona = listCorona[position]
        Glide.with(holder.itemView.context)
            .load(corona.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvName.text = corona.name
        holder.tvTotal.text = "Total Kasus : " + corona.total.toString()
        holder.tvDeath.text = "Meninggal : " + corona.death.toString()
        holder.tvRecoveries.text = "Sembuh : " +  corona.recoveries.toString()

        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "Kamu memilih " + listCorona[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
//            Toast.makeText(holder.itemView.context, holder.adapterPosition.toString(), Toast.LENGTH_SHORT).show()
            val value = listOf(holder.tvName.text, holder.tvTotal.text,holder.tvDeath.text, holder.tvRecoveries.text)
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)

            intent.putExtra("position", position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listCorona.size
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvTotal: TextView = itemView.findViewById(R.id.tv_item_cases)
        var tvDeath : TextView = itemView.findViewById(R.id.tv_item_death)
        var tvRecoveries : TextView = itemView.findViewById(R.id.tv_item_recoveries)

    }
}
