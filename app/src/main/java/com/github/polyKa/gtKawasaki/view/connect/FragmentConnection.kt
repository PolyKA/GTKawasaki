package com.github.polyKa.gtKawasaki.view.connect

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.polyKa.gtKawasaki.R
import com.github.polyKa.gtKawasaki.databinding.FragmentConnectionBinding

// The path that images are taken for ImageView
private const val ROBOT_IMAGE_DIRECTORY = "robot_images"

/**
 * The fragment is responsible for connecting to the robot.
 * @author Artem Gerasimov.
 */
class FragmentConnection : Fragment() {
    private lateinit var viewModel: ConnectionViewModel
    private lateinit var binding: FragmentConnectionBinding

    /**
     * Create binding..
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Connect to data binding
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_connection, container, false)
        binding.executePendingBindings()

        return binding.root
    }

    /**
     * Connect view model.
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ConnectionViewModel::class.java)

        // Start updating images.
        viewModel.startChangeImage(ROBOT_IMAGE_DIRECTORY, binding.ivConnectImageAnimation)
    }

    /**
     * Stop updating images.
     */
    override fun onDestroy() {
        viewModel.stopChangeImage()
        super.onDestroy()
    }
}
