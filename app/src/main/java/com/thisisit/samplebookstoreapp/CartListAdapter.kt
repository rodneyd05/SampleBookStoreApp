package com.thisisit.samplebookstoreapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartListAdapter(private var bookList: List<Book>): RecyclerView.Adapter<CartListAdapter.BookListHolder>() {

    class BookListHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val bookTitle: TextView = itemView.findViewById(R.id.bookTitle)
        val bookAuthor: TextView = itemView.findViewById(R.id.bookAuthor)
        val bookImage: ImageView = itemView.findViewById(R.id.bookImage)
    }

    //when setFiltered and filteredList is passed, filteredList is assigned to be displayed in recyclerView
    fun setFiltered(mList: List<Book>) {
        this.bookList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookListHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.cart_list_design, parent, false)

        return BookListHolder(view)
    }

    override fun onBindViewHolder(holder: BookListHolder, position: Int) {
        holder.bookImage.setImageResource(bookList[position].image)
        holder.bookTitle.text = bookList[position].title
        holder.bookAuthor.text = bookList[position].author
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}