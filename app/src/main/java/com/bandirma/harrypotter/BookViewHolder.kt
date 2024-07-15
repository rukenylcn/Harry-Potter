package com.bandirma.harrypotter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BookViewHolder(val container: ViewGroup): RecyclerView.ViewHolder(
    LayoutInflater.from(container.context)
        .inflate(R.layout.books_item,container, false)

) {
    fun bind(bookModel:bookdataModel){
        val imagebook= itemView.findViewById<ImageView>(R.id.imagebook)
        val tvBookName=itemView.findViewById<TextView>(R.id.tvBookName)
        val autorname=itemView.findViewById<TextView>(R.id.autorname)
        val yayınlanmatarihi=itemView.findViewById<TextView>(R.id.yayınlanmatarihi)


        tvBookName.text=bookModel.name
        autorname.text=bookModel.author
       yayınlanmatarihi.text=bookModel.release_data

        Glide
            .with(itemView.context)
            .load(bookModel.book_image)
            .into(imagebook)
    }
}