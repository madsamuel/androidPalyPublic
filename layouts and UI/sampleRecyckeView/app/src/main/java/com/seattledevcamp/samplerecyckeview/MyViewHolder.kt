package com.seattledevcamp.samplerecyckeview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView: ImageView
    var nameView: TextView
    var emailView: TextView

    init {
        imageView = itemView.findViewById(R.id.imageView)
        nameView = itemView.findViewById(R.id.name)
        emailView = itemView.findViewById(R.id.email)
    }
}
