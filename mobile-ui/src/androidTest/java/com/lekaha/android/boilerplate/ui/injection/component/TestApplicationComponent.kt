package com.lekaha.android.boilerplate.ui.injection.component

import android.app.Application
import com.lekaha.android.boilerplate.domain.executor.PostExecutionThread
import com.lekaha.android.boilerplate.domain.repository.BufferooRepository
import com.lekaha.android.boilerplate.ui.injection.module.TestActivityBindingModule
import com.lekaha.android.boilerplate.ui.injection.module.TestApplicationModule
import com.lekaha.android.boilerplate.ui.injection.scopes.PerApplication
import com.lekaha.android.boilerplate.ui.test.TestApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [TestApplicationModule::class, TestActivityBindingModule::class,
        AndroidSupportInjectionModule::class]
)
@PerApplication
interface TestApplicationComponent : ApplicationComponent {

    fun bufferooRepository(): BufferooRepository

    fun postExecutionThread(): PostExecutionThread

    fun inject(application: TestApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): TestApplicationComponent
    }

}