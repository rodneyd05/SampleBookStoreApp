package com.thisisit.samplebookstoreapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.thisisit.samplebookstoreapp.databinding.FragmentYourBooksBinding

class YourBooksFragment : Fragment() {

    private lateinit var yourBooksBinding: FragmentYourBooksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    //If viewBinding is used, View should be made non-nullable instead of View?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_your_books, container, false)
        yourBooksBinding = FragmentYourBooksBinding.inflate(layoutInflater)
        return yourBooksBinding.root
    }

    //call and override this function
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //use context instead of (this@YourBooksFragment)
        yourBooksBinding.myBookListRecyclerView.layoutManager = LinearLayoutManager(context)
        val bookListAdapter = BookListAdapter(myBookList)
        yourBooksBinding.myBookListRecyclerView.adapter = bookListAdapter
    }
}