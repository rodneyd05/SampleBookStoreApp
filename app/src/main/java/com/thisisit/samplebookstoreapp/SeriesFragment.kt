package com.thisisit.samplebookstoreapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thisisit.samplebookstoreapp.databinding.FragmentSeriesBinding

class SeriesFragment : Fragment() {

    private lateinit var seriesBinding: FragmentSeriesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        //If viewBinding is used, View should be made non-nullable instead of View?
    ): View {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_cart, container, false)
        seriesBinding = FragmentSeriesBinding.inflate(layoutInflater)
        return seriesBinding.root
    }
}