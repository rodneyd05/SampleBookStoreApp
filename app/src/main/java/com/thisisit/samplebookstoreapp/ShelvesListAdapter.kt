package com.thisisit.samplebookstoreapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ShelvesListAdapter(private var list: List<Book>): RecyclerView.Adapter<ShelvesListAdapter.BookListHolder>() {

    class BookListHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val bookTitle: TextView = itemView.findViewById(R.id.bookTitle)
        val bookAuthor: TextView = itemView.findViewById(R.id.bookAuthor)
        val bookImage: ImageView = itemView.findViewById(R.id.bookImage)
        val addToCart: ImageView = itemView.findViewById(R.id.cart)
    }

    //when setFiltered and filteredList is passed, filteredList is assigned to be displayed in recyclerView
    fun updateShelvesList(mList: List<Book>) {
        this.list = mList
        //notifyDataSetChanged() to update the list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookListHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.shelves_list_design, parent, false)

        return BookListHolder(view)
    }

    override fun onBindViewHolder(holder: BookListHolder, position: Int) {
        holder.bookImage.setImageResource(list[position].image)
        holder.bookTitle.text = list[position].title
        holder.bookAuthor.text = list[position].author
        holder.addToCart.setOnClickListener { v ->
            //removeAt removes the item from the bookList and return the value to be added in cartList
            val added = bookList.removeAt(holder.adapterPosition)
            cartList.add(added)

            updateShelvesList(bookList)
            Toast.makeText(v!!.context, "Added ${added.title}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}