package com.lekaha.android.boilerplate.ui.injection.module

import com.lekaha.android.boilerplate.ui.browse.BrowseFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TestFragmentBindingModule {

    @ContributesAndroidInjector(
        modules = [BrowseModule::class, TestBrowseActivityModule::class]
    )
    abstract fun provideBrowseFragment(): BrowseFragment
}