package com.lekaha.android.boilerplate.ui.browse

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lekaha.android.boilerplate.ui.R
import com.lekaha.android.boilerplate.ui.injection.scopes.PerActivity
import com.lekaha.android.boilerplate.ui.model.BufferooViewModel
import com.lekaha.android.boilerplate.ui.view.recycler.DisplayableItem
import com.lekaha.android.boilerplate.ui.view.recycler.ViewHolderBinder
import com.lekaha.android.boilerplate.ui.view.recycler.ViewHolderFactory
import javax.inject.Inject

class BrowseViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var avatarImage: ImageView = view.findViewById(R.id.image_avatar)
    var nameText: TextView = view.findViewById(R.id.text_name)
    var titleText: TextView = view.findViewById(R.id.text_title)

    fun bind(bufferoo: BufferooViewModel) {
        nameText.text = bufferoo.name
        titleText.text = bufferoo.title

        Glide.with(itemView.context)
                .load(bufferoo.avatar)
                .apply(RequestOptions.circleCropTransform())
                .into(avatarImage)
    }


    class BrowseViewHolderFactory @Inject constructor(context: Context):
            ViewHolderFactory(context) {

        override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
                = BrowseViewHolder(LayoutInflater
                    .from(context)
                    .inflate(R.layout.item_bufferoo, parent, false))

    }

    class BrowseViewHolderBinder @Inject constructor(): ViewHolderBinder {
        override fun bind(viewHolder: RecyclerView.ViewHolder,
                          item: DisplayableItem<*>) {
            var browseViewHolder = BrowseViewHolder::class.java.cast(viewHolder)
            var bufferooViewModel = BufferooViewModel::class.java.cast(item.model())
            browseViewHolder.bind(bufferooViewModel)
        }

    }
}