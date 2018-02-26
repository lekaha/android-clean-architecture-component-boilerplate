package com.lekaha.android.boilerplate.ui.injection.module

import com.lekaha.android.boilerplate.ui.BaseActivity
import com.lekaha.android.boilerplate.ui.Navigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    fun provideNavigator(baseActivity: BaseActivity) = Navigator(baseActivity)
}