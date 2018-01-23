package com.lekaha.android.boilerplate.ui.injection.module

import dagger.Module
import dagger.Provides
import com.lekaha.android.boilerplate.domain.interactor.browse.GetBufferoos
import com.lekaha.android.boilerplate.presentation.browse.BrowseBufferoosContract
import com.lekaha.android.boilerplate.presentation.browse.BrowseBufferoosPresenter
import com.lekaha.android.boilerplate.presentation.mapper.BufferooMapper
import com.lekaha.android.boilerplate.ui.browse.BrowseActivity
import com.lekaha.android.boilerplate.ui.injection.scopes.PerActivity



/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BrowseActivityModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(browseActivity: BrowseActivity): BrowseBufferoosContract.View {
        return browseActivity
    }

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(mainView: BrowseBufferoosContract.View,
                                        getBufferoos: GetBufferoos, mapper: BufferooMapper):
            BrowseBufferoosContract.Presenter {
        return BrowseBufferoosPresenter(mainView, getBufferoos, mapper)
    }

}
