package com.lekaha.android.boilerplate.remote.service

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Provide "make" methods to create instances of [HttpServiceFactory]
 * and its related dependencies, such as OkHttpClient, Gson, etc.
 */
abstract class HttpServiceFactory<out S>: ServiceFactory<S> {
    override fun makeService(isDebug: Boolean): S {
        throw UnsupportedOperationException()
    }

    abstract fun makeService(isDebug: Boolean,
                                       baseUrl: String,
                                       connectTimeout: Long,
                                       readTimeout: Long,
                                       interceptors: Array<Interceptor>): S


    protected fun makeOkHttpClient(isDebug: Boolean,
                                   connectTimeout: Long,
                                   readTimeout: Long,
                                   interceptors: Array<Interceptor>) =
            OkHttpClient.Builder().apply {
                addInterceptor(makeLoggingInterceptor(isDebug))
                if (isDebug) interceptors.forEach { addInterceptor(it) }
                connectTimeout(connectTimeout, TimeUnit.SECONDS)
                readTimeout(readTimeout, TimeUnit.SECONDS)
            }.build()

    protected fun makeGson() =
            GsonBuilder()
                    .setLenient()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create()

    protected fun makeLoggingInterceptor(isDebug: Boolean) =
            HttpLoggingInterceptor().apply {
                level = if (isDebug) HttpLoggingInterceptor.Level.BODY
                        else HttpLoggingInterceptor.Level.NONE
            }
}