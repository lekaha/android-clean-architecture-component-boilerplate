package com.lekaha.android.boilerplate.ui.view.recycler

import android.support.v7.util.DiffUtil

class DiffUtilCallback(private var oldItems: List<DisplayableItem<*>>,
                       private var newItems: List<DisplayableItem<*>>,
                       private var comparator: ItemComparator): DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
            = comparator.areItemsTheSame(oldItems[oldItemPosition]
                , newItems[newItemPosition])

    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
            = comparator.areContentsTheSame(oldItems[oldItemPosition]
                , newItems[newItemPosition])

}