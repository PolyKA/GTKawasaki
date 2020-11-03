package com.github.polyKa.gtKawasaki.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.polyKa.gtKawasaki.R
import com.github.polyKa.gtKawasaki.databinding.FragmentMainScreenFragmentBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MainScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainScreenFragment : Fragment() {
    private lateinit var binding: FragmentMainScreenFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Connect to data binding
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_main_screen_fragment, container, false)
        binding.executePendingBindings()

//        // Inflate the layout for this fragment
//        val activity = (requireActivity() as AppCompatActivity)
//        activity.setSupportActionBar(binding.bottomAppBar)
//
//        binding.bottomAppBar.replaceMenu(R.menu.menu_bottom_panel)

        return binding.root
    }

}