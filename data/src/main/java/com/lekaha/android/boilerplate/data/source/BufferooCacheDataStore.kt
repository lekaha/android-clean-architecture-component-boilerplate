package com.lekaha.android.boilerplate.data.source

import com.lekaha.android.boilerplate.data.model.BufferooEntity
import com.lekaha.android.boilerplate.data.repository.BufferooCache
import com.lekaha.android.boilerplate.data.repository.BufferooDataStore
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Implementation of the [BufferooDataStore] interface to provide a means of communicating
 * with the local data source
 */
open class BufferooCacheDataStore constructor(private val bufferooCache: BufferooCache) :
    BufferooDataStore {

    /**
     * Clear all Bufferoos from the cache
     */
    override fun clearBufferoos(): Completable {
        return bufferooCache.clearBufferoos()
    }

    /**
     * Save a given [List] of [BufferooEntity] instances to the cache
     */
    override fun saveBufferoos(bufferoos: List<BufferooEntity>): Completable {
        return bufferooCache.saveBufferoos(bufferoos)
            .doOnComplete {
                bufferooCache.setLastCacheTime(System.currentTimeMillis())
            }
    }

    /**
     * Retrieve a list of [BufferooEntity] instance from the cache
     */
    override fun getBufferoos(): Single<List<BufferooEntity>> {
        return bufferooCache.getBufferoos()
    }

}