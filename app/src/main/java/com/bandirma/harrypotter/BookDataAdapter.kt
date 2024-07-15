package com.bandirma.harrypotter

import android.os.Parcel
import android.os.Parcelable
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BookDataAdapter(val bookList: ArrayList<bookdataModel>) : RecyclerView.Adapter<BookViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(parent)
    }

    override fun getItemCount(): Int {
       return bookList.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
     holder.bind(bookList[position])
    }


}
