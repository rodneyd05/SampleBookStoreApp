package com.thisisit.samplebookstoreapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.thisisit.samplebookstoreapp.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    private lateinit var cartBinding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cartBinding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(cartBinding.root)

        //to change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "Cart"

        cartBinding.cartListRecyclerView.layoutManager = LinearLayoutManager(this@CartActivity)
        val cartListAdapter = CartListAdapter(cartList)
        cartBinding.cartListRecyclerView.adapter = cartListAdapter
    }
}