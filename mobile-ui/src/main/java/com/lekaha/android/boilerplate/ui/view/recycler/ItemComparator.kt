package com.lekaha.android.boilerplate.ui.view.recycler

interface ItemComparator {
    fun areItemsTheSame(itemLeft: DisplayableItem<*>, itemRight: DisplayableItem<*>): Boolean
    fun areContentsTheSame(itemLeft: DisplayableItem<*>, itemRight: DisplayableItem<*>): Boolean
}