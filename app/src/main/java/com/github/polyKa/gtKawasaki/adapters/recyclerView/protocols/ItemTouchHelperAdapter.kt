package com.github.polyKa.gtKawasaki.adapters.recyclerView.protocols

/**
 * Interface that defines changes when moving and when deleting
 * items in recycler view.
 *
 * @author artem241120@gmail.com(Artem Gerasimov)
 */
interface ItemTouchHelperAdapter {
    fun onItemMove(fromPosition: Int, toPosition: Int): Boolean

    fun onItemDismiss(position: Int)
}