package com.github.polyKa.gtKawasaki.customRV

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.polyKa.gtKawasaki.view.MainActivity
import com.github.polyKa.gtKawasaki.customRV.adapters.protocols.ItemTouchHelperAdapter
import com.github.polyKa.gtKawasaki.customRV.adapters.ProgramRecyclerViewAdapter
import com.github.polyKa.gtKawasaki.customRV.adapters.protocols.OnDeleteButtonClick
import com.github.polyKa.gtKawasaki.customRV.adapters.protocols.OnItemClickListener
import com.github.polyKa.gtKawasaki.customRV.helpers.SimpleItemTouchHelperCallback
import com.github.polyKa.gtKawasaki.repository.commands.Command
import java.util.*

/**
 * Customization command recycler view:
 * create adapters, layout managers,
 * customization dag and swipe.
 *
 * @param recyclerView - recycler view for configuration
 * @param activity - to get context
 * @param list - data to upload
 * @param onItemClickListener - action when clicking on a cell in recycler view
 * @param onDeleteButtonClick - action when clicking on a delete button
 *
 * @author Artem Gerasimov
 */
class CustomizationCommandRecyclerView(
    recyclerView: RecyclerView,
    private val activity: MainActivity,
    private val list: MutableLiveData<MutableList<Command>>, //!!
    onItemClickListener: OnItemClickListener,
    onDeleteButtonClick: OnDeleteButtonClick,
    private val resources: Resources): ItemTouchHelperAdapter {

    private var programRecyclerView: ProgramRecyclerViewAdapter
            = ProgramRecyclerViewAdapter(arrayListOf(),
                                         onItemClickListener,
                                         onDeleteButtonClick, this)

    init {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = programRecyclerView

        val callback: ItemTouchHelper.Callback = SimpleItemTouchHelperCallback(programRecyclerView)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerView)

        updateItems()
    }

    /**
     * Method for updating fields in the recycler view
     */
    fun updateItems(){
        list.observe(activity,
            {
                it.let {
                    programRecyclerView.replaceData(it.toList())
                }
            })
    }

    /**
     * Action on drag - moving an item
     * @param fromPosition - starting element position
     * @param toPosition - new element position
     */
    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(list.value!!, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(list.value!!, i, i - 1)
            }
        }
        return true
    }

    /**
     * Action to swipe - delete the item
     * @param position - position of the file to delete
     */
    override fun onItemDismiss(position: Int) {
        list.value?.removeAt(position)
    }
}