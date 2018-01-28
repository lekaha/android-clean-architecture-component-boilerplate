package com.lekaha.android.boilerplate.ui.browse

import com.lekaha.android.boilerplate.ui.view.recycler.DisplayableItem
import com.lekaha.android.boilerplate.ui.view.recycler.ItemComparator
import com.lekaha.android.boilerplate.ui.view.recycler.RecyclerViewAdapter
import com.lekaha.android.boilerplate.ui.view.recycler.ViewHolderFactory
import com.lekaha.android.boilerplate.ui.view.recycler.ViewHolderBinder

class BrowseAdapter(itemComparator: ItemComparator,
                    factoryMap: Map<Int, ViewHolderFactory>,
                    binderMap: Map<Int, ViewHolderBinder>):
        RecyclerViewAdapter(itemComparator, factoryMap, binderMap) {


    class BrowseItemComparator: ItemComparator {
        override fun areItemsTheSame(itemLeft: DisplayableItem<*>,
                                     itemRight: DisplayableItem<*>): Boolean
                = itemLeft == itemRight

        override fun areContentsTheSame(itemLeft: DisplayableItem<*>,
                                        itemRight: DisplayableItem<*>): Boolean
                = itemLeft == itemRight

    }
}