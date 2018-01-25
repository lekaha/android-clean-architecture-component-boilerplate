package com.lekaha.android.boilerplate.ui.browse

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lekaha.android.boilerplate.ui.R
import com.lekaha.android.boilerplate.ui.model.BufferooViewModel
import com.lekaha.android.boilerplate.ui.view.recycler.*
import javax.inject.Inject

//class BrowseAdapter @Inject constructor(): RecyclerView.Adapter<BrowseAdapter.ViewHolder>() {
//
//    var bufferoos: List<BufferooViewModel> = arrayListOf()
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val bufferoo = bufferoos[position]
//        holder.nameText.text = bufferoo.name
//        holder.titleText.text = bufferoo.title
//
//        Glide.with(holder.itemView.context)
//                .load(bufferoo.avatar)
//                .apply(RequestOptions.circleCropTransform())
//                .into(holder.avatarImage)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val itemView = LayoutInflater
//                .from(parent.context)
//                .inflate(R.layout.item_bufferoo, parent, false)
//        return ViewHolder(itemView)
//    }
//
//    override fun getItemCount(): Int {
//        return bufferoos.size
//    }
//
//    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        var avatarImage: ImageView
//        var nameText: TextView
//        var titleText: TextView
//
//        init {
//            avatarImage = view.findViewById(R.id.image_avatar)
//            nameText = view.findViewById(R.id.text_name)
//            titleText = view.findViewById(R.id.text_title)
//        }
//    }
//
//}

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