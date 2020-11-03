package com.github.polyKa.gtKawasaki.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.github.polyKa.gtKawasaki.R
import com.github.polyKa.gtKawasaki.adapters.fragmentPager.ProgramAndPointFragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProgramAndPointTabHostFragment : Fragment() {
    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    private lateinit var programAndPointFragmentPagerAdapter: ProgramAndPointFragmentPagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_program_and_point_tab_host, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        programAndPointFragmentPagerAdapter = ProgramAndPointFragmentPagerAdapter(this)
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = programAndPointFragmentPagerAdapter


        val tabLayout = view.findViewById<TabLayout>(R.id.tabs)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position){
                0 -> tab.text = resources.getText(R.string.tab_menu_program)
                1 -> tab.text = resources.getText(R.string.tab_menu_point)
            }
        }.attach()
    }
}