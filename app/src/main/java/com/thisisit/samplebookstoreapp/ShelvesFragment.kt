package com.thisisit.samplebookstoreapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.thisisit.samplebookstoreapp.databinding.FragmentShelvesBinding

class ShelvesFragment : Fragment() {

    private lateinit var shelvesBinding: FragmentShelvesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        //If viewBinding is used, View should be made non-nullable instead of View?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_your_books, container, false)
        shelvesBinding = FragmentShelvesBinding.inflate(layoutInflater)
        return shelvesBinding.root
    }

    //call and override this function
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //use context instead of (this@YourBooksFragment)
        shelvesBinding.bookListRecyclerView.layoutManager = LinearLayoutManager(context)
        val bookListAdapter = BookListAdapter(bookList)
        shelvesBinding.bookListRecyclerView.adapter = bookListAdapter
    }
}