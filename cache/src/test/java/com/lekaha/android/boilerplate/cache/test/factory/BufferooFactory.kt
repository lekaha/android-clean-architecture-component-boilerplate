package com.lekaha.android.boilerplate.cache.test.factory

import com.lekaha.android.boilerplate.cache.model.CachedBufferoo
import com.lekaha.android.boilerplate.data.model.BufferooEntity
import com.lekaha.android.boilerplate.cache.test.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for Bufferoo related instances
 */
class BufferooFactory {

    companion object Factory {

        fun makeCachedBufferoo(): CachedBufferoo {
            return CachedBufferoo(randomUuid(), randomUuid(), randomUuid())
        }

        fun makeBufferooEntity(): BufferooEntity {
            return BufferooEntity(randomUuid(), randomUuid(), randomUuid())
        }

        fun makeBufferooEntityList(count: Int): List<BufferooEntity> {
            val bufferooEntities = mutableListOf<BufferooEntity>()
            repeat(count) {
                bufferooEntities.add(makeBufferooEntity())
            }
            return bufferooEntities
        }

        fun makeCachedBufferooList(count: Int): List<CachedBufferoo> {
            val cachedBufferoos = mutableListOf<CachedBufferoo>()
            repeat(count) {
                cachedBufferoos.add(makeCachedBufferoo())
            }
            return cachedBufferoos
        }

    }

}