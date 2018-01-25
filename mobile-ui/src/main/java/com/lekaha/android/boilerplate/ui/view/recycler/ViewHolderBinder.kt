package com.lekaha.android.boilerplate.ui.view.recycler

import android.support.v7.widget.RecyclerView.ViewHolder

/**
 * Populates a [ViewHolder] with the model details.
 */
interface ViewHolderBinder {

    /**
     * Populates the passed [ViewHolder] with the details of the passed [DisplayableItem].
     */
    fun bind(viewHolder: ViewHolder, item: DisplayableItem<*>)
}
