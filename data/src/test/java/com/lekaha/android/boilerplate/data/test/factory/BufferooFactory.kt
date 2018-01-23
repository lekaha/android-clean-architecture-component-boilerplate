package com.lekaha.android.boilerplate.data.test.factory

import com.lekaha.android.boilerplate.data.model.BufferooEntity
import com.lekaha.android.boilerplate.data.test.factory.DataFactory.Factory.randomUuid
import com.lekaha.android.boilerplate.domain.model.Bufferoo

/**
 * Factory class for Bufferoo related instances
 */
class BufferooFactory {

    companion object Factory {

        fun makeBufferooEntity(): BufferooEntity {
            return BufferooEntity(randomUuid(), randomUuid(), randomUuid())
        }

        fun makeBufferoo(): Bufferoo {
            return Bufferoo(randomUuid(), randomUuid(), randomUuid())
        }

        fun makeBufferooEntityList(count: Int): List<BufferooEntity> {
            val bufferooEntities = mutableListOf<BufferooEntity>()
            repeat(count) {
                bufferooEntities.add(makeBufferooEntity())
            }
            return bufferooEntities
        }

        fun makeBufferooList(count: Int): List<Bufferoo> {
            val bufferoos = mutableListOf<Bufferoo>()
            repeat(count) {
                bufferoos.add(makeBufferoo())
            }
            return bufferoos
        }

    }

}