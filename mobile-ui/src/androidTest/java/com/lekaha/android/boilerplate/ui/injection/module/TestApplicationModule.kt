package com.lekaha.android.boilerplate.ui.injection.module

import android.app.Application
import android.content.Context
import com.lekaha.android.boilerplate.cache.PreferencesHelper
import com.lekaha.android.boilerplate.data.executor.JobExecutor
import com.lekaha.android.boilerplate.data.repository.BufferooCache
import com.lekaha.android.boilerplate.data.repository.BufferooRemote
import com.lekaha.android.boilerplate.domain.executor.PostExecutionThread
import com.lekaha.android.boilerplate.domain.executor.ThreadExecutor
import com.lekaha.android.boilerplate.domain.repository.BufferooRepository
import com.lekaha.android.boilerplate.remote.BufferooService
import com.lekaha.android.boilerplate.ui.UiThread
import com.lekaha.android.boilerplate.ui.injection.qualifier.ApplicationContext
import com.lekaha.android.boilerplate.ui.injection.scopes.PerApplication
import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides

@Module
class TestApplicationModule {

    @Provides
    @PerApplication
    @ApplicationContext
    fun provideContext(application: Application): Context = application

    @Provides
    @PerApplication
    internal fun providePreferencesHelper(): PreferencesHelper = mock()

    @Provides
    @PerApplication
    internal fun provideBufferooRepository(): BufferooRepository = mock()

    @Provides
    @PerApplication
    internal fun provideBufferooCache(): BufferooCache = mock()

    @Provides
    @PerApplication
    internal fun provideBufferooRemote(): BufferooRemote = mock()

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread = uiThread

    @Provides
    @PerApplication
    internal fun provideBufferooService(): BufferooService = mock()

    @Provides
    @PerApplication
    internal fun provideUiThread() = UiThread()

    @Provides
    @PerApplication
    internal fun provideJobExecutor() = JobExecutor()

}