package com.lekaha.android.boilerplate.ui.injection.module

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.lekaha.android.boilerplate.remote.BufferooService
import com.lekaha.android.boilerplate.remote.BufferooServiceFactory
import com.lekaha.android.boilerplate.ui.BuildConfig
import com.lekaha.android.boilerplate.ui.injection.scopes.PerApplication
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides

@Module
open class NetModule {

    @Provides
    @PerApplication
    internal fun provideBufferooService(chuckInterceptor: ChuckInterceptor,
                                        stethoInterceptor: StethoInterceptor
                                        ): BufferooService {
        return BufferooServiceFactory.makeBuffeoorService(
                BuildConfig.DEBUG,
                chuckInterceptor,
                stethoInterceptor)
    }

    @Provides
    internal fun provideChuckInterceptor(context: Context): ChuckInterceptor
            = ChuckInterceptor(context)

    @Provides
    internal fun provideStethoInterceptor(): StethoInterceptor
            = StethoInterceptor()
}