package com.github.polyKa.gtKawasaki.adapters.fragmentPager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.github.polyKa.gtKawasaki.view.ShowProgramFragment

class ProgramAndPointFragmentPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment)  {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->ShowProgramFragment()
            1->ShowProgramFragment()
            else -> ShowProgramFragment()
        }
    }
}

