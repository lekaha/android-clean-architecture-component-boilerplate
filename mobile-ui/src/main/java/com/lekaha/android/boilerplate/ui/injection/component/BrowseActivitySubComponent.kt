package com.lekaha.android.boilerplate.ui.injection.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import com.lekaha.android.boilerplate.ui.browse.BrowseActivity

@Subcomponent
interface BrowseActivitySubComponent: AndroidInjector<BrowseActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<BrowseActivity>()

}