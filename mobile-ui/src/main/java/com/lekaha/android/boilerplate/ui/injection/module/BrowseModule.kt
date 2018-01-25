package com.lekaha.android.boilerplate.ui.injection.module

import com.lekaha.android.boilerplate.ui.browse.BrowseAdapter
import com.lekaha.android.boilerplate.ui.browse.BrowseViewHolder
import com.lekaha.android.boilerplate.ui.view.recycler.ItemComparator
import com.lekaha.android.boilerplate.ui.view.recycler.ViewHolderBinder
import com.lekaha.android.boilerplate.ui.view.recycler.ViewHolderFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntKey
import dagger.multibindings.IntoMap

@Module
abstract class BrowseModule {

    companion object {
        const val DISPLAY_TYPE_BROWSE: Int = 3

        @Provides fun provideRecyclerAdapter(itemComparator: ItemComparator,
                                             factoryMap: Map<Int, ViewHolderFactory>,
                                             binderMap: Map<Int, ViewHolderBinder>)
                = BrowseAdapter(itemComparator, factoryMap, binderMap)

        @Provides fun provideCopmarator(): ItemComparator = BrowseAdapter.BrowseItemComparator()
    }

    @Binds
    @IntoMap
    @IntKey(BrowseModule.DISPLAY_TYPE_BROWSE)
    abstract fun provideBrowseViewHolderFactory(factory: BrowseViewHolder.BrowseViewHolderFactory)

    @Binds
    @IntoMap
    @IntKey(BrowseModule.DISPLAY_TYPE_BROWSE)
    abstract fun provideBrowseViewHolderBinder(binder: BrowseViewHolder.BrowseViewHolderBinder)
}