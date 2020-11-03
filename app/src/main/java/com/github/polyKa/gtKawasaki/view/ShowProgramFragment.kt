package com.github.polyKa.gtKawasaki.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.github.polyKa.gtKawasaki.R
import com.github.polyKa.gtKawasaki.helpers.CustomizationCommandRecyclerView
import com.github.polyKa.gtKawasaki.adapters.recyclerView.protocols.OnDeleteButtonClick
import com.github.polyKa.gtKawasaki.adapters.recyclerView.protocols.OnItemClickListener
import com.github.polyKa.gtKawasaki.databinding.FragmentShowProgramBinding
import com.github.polyKa.gtKawasaki.repository.commands.*

class ShowProgramFragment : Fragment(), OnItemClickListener, OnDeleteButtonClick {
    private lateinit var binding: FragmentShowProgramBinding

    private lateinit var customizationCommandRecyclerView: CustomizationCommandRecyclerView

    /**
     * Clicking on an item in recyclerview takes
     * you to a fragment that changes the command.
     */
    override fun onItemClick(position: Int) {
        val bundle = Bundle()
        bundle.putInt("position", position)

//        viewModel.robot.stopSendCommands()
//        when (viewModel.programList.value?.get(position)) {
//            is MoveToPoint -> findNavController().navigate(R.id.addMovingToPointFragment, bundle)
//            is Move -> findNavController().navigate(R.id.addMoveActionFragment, bundle)
//            is For -> findNavController().navigate(R.id.addForCommandFragment, bundle)
//        }
    }

    /**
     * When user click the delete button in item
     * in recyclerview-delete a position from the array.
     */
    override fun onDeleteButtonClick(position: Int) {
//        viewModel.programList.value?.removeAt(position)
        customizationCommandRecyclerView.updateItems()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Connect to data binding
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_show_program, container, false)
        binding.executePendingBindings()

        val programList = MutableLiveData<MutableList<Command>>()
        programList.value = mutableListOf(OpenGripper())
            with(programList.value){
                this?.add(MoveByCoordinate())
                this?.add(CloseGripper())
                this?.add(MoveToPoint())
                this?.add(OpenGripper())
                this?.add(MoveByCoordinate())
                this?.add(CloseGripper())
                this?.add(MoveToPoint())
                this?.add(OpenGripper())
                this?.add(MoveByCoordinate())
                this?.add(CloseGripper())
                this?.add(MoveToPoint())
                this?.add(OpenGripper())
                this?.add(MoveByCoordinate())
                this?.add(CloseGripper())
                this?.add(MoveToPoint())
                this?.add(OpenGripper())
                this?.add(MoveByCoordinate())
                this?.add(CloseGripper())
                this?.add(MoveToPoint())
                this?.add(OpenGripper())

            }

        // Customization RecycleView: set layoutManager, adapter, data.
        customizationCommandRecyclerView = CustomizationCommandRecyclerView(binding.rvShowProgram,
            activity as MainActivity,
            programList,
            this,
            this, resources)

        return binding.root
    }
}
