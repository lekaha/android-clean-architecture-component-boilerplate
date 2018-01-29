package com.lekaha.android.boilerplate.ui.injection.module

import com.lekaha.android.boilerplate.ui.browse.BrowseActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules =
        arrayOf(FragmentBindingModule::class))
    abstract fun bindMainActivity(): BrowseActivity

}