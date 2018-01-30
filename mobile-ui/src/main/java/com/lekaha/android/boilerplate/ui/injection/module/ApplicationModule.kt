package com.lekaha.android.boilerplate.ui.injection.module

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.lekaha.android.boilerplate.cache.BufferooCacheImpl
import com.lekaha.android.boilerplate.cache.PreferencesHelper
import com.lekaha.android.boilerplate.cache.db.DbOpenHelper
import com.lekaha.android.boilerplate.cache.mapper.BufferooEntityMapper
import com.lekaha.android.boilerplate.data.BufferooDataRepository
import com.lekaha.android.boilerplate.data.executor.JobExecutor
import com.lekaha.android.boilerplate.data.mapper.BufferooMapper
import com.lekaha.android.boilerplate.data.repository.BufferooCache
import com.lekaha.android.boilerplate.data.repository.BufferooRemote
import com.lekaha.android.boilerplate.data.source.BufferooDataStoreFactory
import com.lekaha.android.boilerplate.domain.executor.PostExecutionThread
import com.lekaha.android.boilerplate.domain.executor.ThreadExecutor
import com.lekaha.android.boilerplate.domain.repository.BufferooRepository
import com.lekaha.android.boilerplate.remote.BufferooRemoteImpl
import com.lekaha.android.boilerplate.remote.BufferooService
import com.lekaha.android.boilerplate.ui.UiThread
import com.lekaha.android.boilerplate.ui.injection.scopes.PerApplication
import com.squareup.leakcanary.LeakCanary
import dagger.Module
import dagger.Provides

/**
 * Module used to provide dependencies at an application-level.
 */
@Module
open class ApplicationModule {

    private fun init(application: Application) {
        Stetho.initializeWithDefaults(application)

        if (LeakCanary.isInAnalyzerProcess(application)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(application)
    }

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        init(application)
        return application
    }

    @Provides
    @PerApplication
    internal fun providePreferencesHelper(context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }


    @Provides
    @PerApplication
    internal fun provideBufferooRepository(factory: BufferooDataStoreFactory,
                                           mapper: BufferooMapper): BufferooRepository {
        return BufferooDataRepository(factory, mapper)
    }

    @Provides
    @PerApplication
    internal fun provideBufferooCache(factory: DbOpenHelper,
                                      entityMapper: BufferooEntityMapper,
                                      mapper: com.lekaha.android.boilerplate.cache.db.mapper.BufferooMapper,
                                      helper: PreferencesHelper): BufferooCache {
        return BufferooCacheImpl(factory, entityMapper, mapper, helper)
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRemote(service: BufferooService,
                                       factory: com.lekaha.android.boilerplate.remote.mapper.BufferooEntityMapper): BufferooRemote {
        return BufferooRemoteImpl(service, factory)
    }

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }
}
