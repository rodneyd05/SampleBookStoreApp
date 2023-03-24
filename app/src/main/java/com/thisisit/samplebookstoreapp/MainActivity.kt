package com.thisisit.samplebookstoreapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.thisisit.samplebookstoreapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.bookListRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        val bookListAdapter = BookListAdapter(bookList)
        mainBinding.bookListRecyclerView.adapter = bookListAdapter
    }
}