package com.thisisit.samplebookstoreapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.thisisit.samplebookstoreapp.databinding.FragmentShelvesBinding
import kotlin.collections.ArrayList

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
        val shelvesListAdapter = ShelvesListAdapter(bookList)
        shelvesBinding.bookListRecyclerView.adapter = shelvesListAdapter

        shelvesBinding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

            private fun filterList(query: String?) {
                if (query != null) {
                    val filteredList = ArrayList<Book>()
                    val emptyList = ArrayList<Book>()
                    for (i in bookList) {
                        if (i.title.contains(query, ignoreCase = true) || i.author.contains(query, ignoreCase = true)) {
                            filteredList.add(i)
                        }
                    }
                    if (filteredList.isEmpty()) {
                        shelvesListAdapter.setFiltered(emptyList)
                    } else {
                        shelvesListAdapter.setFiltered(filteredList)
                    }
                }
            }
        })
    }
}