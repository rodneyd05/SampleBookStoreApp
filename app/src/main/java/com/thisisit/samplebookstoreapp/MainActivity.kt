package com.thisisit.samplebookstoreapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.thisisit.samplebookstoreapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var adapter: FragmentPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        adapter = FragmentPageAdapter(supportFragmentManager, lifecycle)
        mainBinding.libraryOptionTabLayout.addTab(mainBinding.libraryOptionTabLayout.newTab().setText("Your Books"))
        mainBinding.libraryOptionTabLayout.addTab(mainBinding.libraryOptionTabLayout.newTab().setText("Shelves"))
        mainBinding.libraryOptionTabLayout.addTab(mainBinding.libraryOptionTabLayout.newTab().setText("Series"))

        mainBinding.cart.setOnClickListener{
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        mainBinding.viewPager2.adapter = adapter
        //to create a relation between tab and fragment
        //implement 2 functions, for tabLayout and viewpager2

        mainBinding.libraryOptionTabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    mainBinding.viewPager2.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        mainBinding.viewPager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                mainBinding.libraryOptionTabLayout.selectTab(mainBinding.libraryOptionTabLayout.getTabAt(position))
            }
        })
    }
}