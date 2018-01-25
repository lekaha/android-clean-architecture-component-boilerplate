package com.lekaha.android.boilerplate.ui.view.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup

/**
 * Instantiates a [ViewHolder] based on the type.
 */
abstract class ViewHolderFactory protected constructor(protected val context: Context) {

    /**
     * Creates a [ViewHolder]
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @return the newly created [ViewHolder]
     */
    abstract fun createViewHolder(parent: ViewGroup): ViewHolder
}
