package com.thisisit.samplebookstoreapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.thisisit.samplebookstoreapp.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private lateinit var cartBinding: FragmentCartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        //If viewBinding is used, View should be made non-nullable instead of View?
    ): View {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_cart, container, false)
        cartBinding = FragmentCartBinding.inflate(layoutInflater)
        return cartBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //use context instead of (this@YourBooksFragment)
        cartBinding.cartListRecyclerView.layoutManager = LinearLayoutManager(context)
        val cartListAdapter = CartListAdapter(cartList)
        cartBinding.cartListRecyclerView.adapter = cartListAdapter
    }
}