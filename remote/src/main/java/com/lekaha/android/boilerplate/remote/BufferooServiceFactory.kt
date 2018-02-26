package com.lekaha.android.boilerplate.remote

import com.google.gson.Gson
import com.lekaha.android.boilerplate.remote.service.HttpServiceFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Provide "make" methods to create instances of [BufferooService]
 * and its related dependencies, such as OkHttpClient, Gson, etc.
 */
object BufferooServiceFactory : HttpServiceFactory<BufferooService>() {

    override fun makeService(isDebug: Boolean,
        baseUrl: String,
        connectTimeout: Long,
        readTimeout: Long,
        interceptors: Array<Interceptor>): BufferooService {

        val okHttpClient = makeOkHttpClient(isDebug, connectTimeout, readTimeout, interceptors)
        return makeBufferooService(baseUrl, okHttpClient, makeGson())
    }

    private fun makeBufferooService(baseUrl: String,
        okHttpClient: OkHttpClient,
        gson: Gson): BufferooService {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create(BufferooService::class.java)
    }
}