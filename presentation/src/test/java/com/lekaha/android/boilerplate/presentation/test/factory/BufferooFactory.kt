package com.lekaha.android.boilerplate.presentation.test.factory

import com.lekaha.android.boilerplate.domain.model.Bufferoo
import com.lekaha.android.boilerplate.presentation.test.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for Bufferoo related instances
 */
class BufferooFactory {

    companion object Factory {

        fun makeBufferooList(count: Int): List<Bufferoo> {
            val bufferoos = mutableListOf<Bufferoo>()
            repeat(count) {
                bufferoos.add(makeBufferooModel())
            }
            return bufferoos
        }

        fun makeBufferooModel(): Bufferoo {
            return Bufferoo(randomUuid(), randomUuid(), randomUuid())
        }

    }

}