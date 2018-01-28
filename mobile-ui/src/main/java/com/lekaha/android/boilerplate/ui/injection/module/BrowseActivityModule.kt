package com.lekaha.android.boilerplate.ui.injection.module

import com.lekaha.android.boilerplate.domain.interactor.browse.GetBufferoos
import com.lekaha.android.boilerplate.presentation.browse.BrowseBufferoosContract
import com.lekaha.android.boilerplate.presentation.browse.BrowseBufferoosPresenter
import com.lekaha.android.boilerplate.presentation.mapper.BufferooMapper
import com.lekaha.android.boilerplate.ui.model.BrowseViewModelFactory
import dagger.Module
import dagger.Provides


/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BrowseActivityModule {

    @Provides
    internal fun provideBrowsePresenter(getBufferoos: GetBufferoos, mapper: BufferooMapper):
            BrowseBufferoosContract.Presenter {
        return BrowseBufferoosPresenter(getBufferoos, mapper)
    }

    @Provides
    internal fun provideBrowseViewModelFactory(presenter: BrowseBufferoosContract.Presenter)
            = BrowseViewModelFactory(presenter)
}
