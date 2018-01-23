package com.lekaha.android.boilerplate.ui.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import com.lekaha.android.boilerplate.ui.BufferooApplication
import com.lekaha.android.boilerplate.ui.injection.module.ActivityBindingModule
import com.lekaha.android.boilerplate.ui.injection.module.ApplicationModule
import com.lekaha.android.boilerplate.ui.injection.scopes.PerApplication

@PerApplication
@Component(modules = arrayOf(ActivityBindingModule::class, ApplicationModule::class,
        AndroidSupportInjectionModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(app: BufferooApplication)

}
