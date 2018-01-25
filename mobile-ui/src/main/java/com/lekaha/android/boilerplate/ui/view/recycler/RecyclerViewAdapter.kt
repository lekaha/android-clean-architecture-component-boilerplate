package com.lekaha.android.boilerplate.ui.view.recycler

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.lekaha.android.boilerplate.common.AndroidPreconditions
import io.reactivex.Single
import java.util.*

/**
 * Implementation of [Adapter] for [DisplayableItem].
 */
open class RecyclerViewAdapter(private val comparator: ItemComparator,
                          private val factoryMap: Map<Int, ViewHolderFactory>,
                          private val binderMap: Map<Int, ViewHolderBinder>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val modelItems = ArrayList<DisplayableItem<*>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return factoryMap[viewType]!!.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = modelItems[position]
        binderMap[item.type()]!!.bind(holder, item)
    }

    override fun getItemCount(): Int {
        return modelItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return modelItems.get(position).type()
    }

    /**
     * Updates modelItems currently stored in adapter with the new modelItems.
     *
     * @param items collection to update the previous values
     */
    fun update(items: List<DisplayableItem<*>>) {
        AndroidPreconditions.assertUiThread()

        if (modelItems.isEmpty()) {
            updateAllItems(items)
        } else {
            updateDiffItemsOnly(items)
        }
    }

    /**
     * Only use for the first update of the adapter, whe it is still empty.
     */
    private fun updateAllItems(items: List<DisplayableItem<*>>) {
        Single.just<List<DisplayableItem<*>>>(items)
                .doOnSuccess { updateItemsInModel(items) }
                .subscribe { _ -> notifyDataSetChanged() }
    }

    /**
     * Do not use for first update of the adapter.
     * The method [DiffUtil.DiffResult.dispatchUpdatesTo] is significantly slower
     * than [ ][RecyclerViewAdapter.notifyDataSetChanged]
     * when it comes to update all the items in the adapter.
     */
    private fun updateDiffItemsOnly(items: List<DisplayableItem<*>>) {
        // IMPROVEMENT: The diff calculation should happen in the background
        Single.fromCallable { calculateDiff(items) }
                .doOnSuccess { updateItemsInModel(items) }
                .subscribe(this::updateAdapterWithDiffResult)
    }

    private fun calculateDiff(newItems: List<DisplayableItem<*>>): DiffUtil.DiffResult {
        return DiffUtil.calculateDiff(DiffUtilCallback(modelItems, newItems, comparator))
    }

    private fun updateItemsInModel(items: List<DisplayableItem<*>>) {
        modelItems.clear()
        modelItems.addAll(items)
    }

    private fun updateAdapterWithDiffResult(result: DiffUtil.DiffResult) {
        result.dispatchUpdatesTo(this)
    }
}