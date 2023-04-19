package com.thisisit.samplebookstoreapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CartListAdapter(private var list: List<Book>): RecyclerView.Adapter<CartListAdapter.BookListHolder>() {

    class BookListHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val bookTitle: TextView = itemView.findViewById(R.id.bookTitle)
        val bookAuthor: TextView = itemView.findViewById(R.id.bookAuthor)
        val bookImage: ImageView = itemView.findViewById(R.id.bookImage)
        val cartRemove: ImageView = itemView.findViewById(R.id.cart_remove)
    }
    fun updateCartList(mList: List<Book>) {
        this.list = mList
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
        holder.bookImage.setImageResource(list[position].image)
        holder.bookTitle.text = list[position].title
        holder.bookAuthor.text = list[position].author

        holder.cartRemove.setOnClickListener {v ->
            val added = cartList.removeAt(holder.adapterPosition)
            bookList.add(added)

            updateCartList(cartList)
            Toast.makeText(v!!.context, "Removed ${added.title}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}