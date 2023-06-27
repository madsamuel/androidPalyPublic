package com.seattledevcamp.samplerecyckeview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyViewAdapter(private var context: Context, private var items: List<MyItems>) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameView.text = items[position].getName()
        holder.emailView.text = items[position].getEmail()
        holder.imageView.setImageResource(items[position].getImage())
    }

    override fun getItemCount(): Int {
        return items.size
    }
}