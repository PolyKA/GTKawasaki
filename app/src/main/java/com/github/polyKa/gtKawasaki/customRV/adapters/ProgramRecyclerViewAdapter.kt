package com.github.polyKa.gtKawasaki.customRV.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.polyKa.gtKawasaki.databinding.ItemToProgramRecyclerViewBinding
import com.github.polyKa.gtKawasaki.customRV.adapters.protocols.ItemTouchHelperAdapter
import com.github.polyKa.gtKawasaki.customRV.adapters.protocols.OnDeleteButtonClick
import com.github.polyKa.gtKawasaki.customRV.adapters.protocols.OnItemClickListener
import com.github.polyKa.gtKawasaki.repository.commands.Command

class ProgramRecyclerViewAdapter(private var items: MutableList<Command>,
                                 private var itemListener: OnItemClickListener,
                                 private var deleteListener: OnDeleteButtonClick,
                                 private val itemTouchHelperAdapter: ItemTouchHelperAdapter
)
    : RecyclerView.Adapter<ProgramRecyclerViewAdapter.ViewHolder>(),
    ItemTouchHelperAdapter {

    /**
     * Create items.
     */
    class ViewHolder(private var binding: ItemToProgramRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(program: Command, listener: OnItemClickListener?,
                 deleteListener: OnDeleteButtonClick
        ) {
            binding.command = program.commandText
            binding.ivCommandImage.setImageResource(program.image)

            if (listener != null) {
                binding.root.setOnClickListener {
                    listener.onItemClick(layoutPosition)
                }

                binding.ivDeletePoint.setOnClickListener {
                    deleteListener.onDeleteButtonClick(layoutPosition)
                }
            }

            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemToProgramRecyclerViewBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(items[position], itemListener, deleteListener)

    override fun getItemCount(): Int = items.size

    /**
     * Data refresh.
     */
    fun replaceData(arrayList: List<Command>) {
        items = arrayList.toMutableList()
        notifyDataSetChanged()
    }

    /**
     * Implements ItemTouchHelper
     */
    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean{
        notifyItemMoved(fromPosition, toPosition)
        return itemTouchHelperAdapter.onItemMove(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        itemTouchHelperAdapter.onItemDismiss(position)
        items.removeAt(position)
        notifyItemRemoved(position)
    }
}