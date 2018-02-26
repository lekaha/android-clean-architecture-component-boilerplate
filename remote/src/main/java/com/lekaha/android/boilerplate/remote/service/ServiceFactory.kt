package com.lekaha.android.boilerplate.remote.service

/**
 * ServiceFactory
 */
interface ServiceFactory<out S> {
    fun makeService(isDebug: Boolean): S
}