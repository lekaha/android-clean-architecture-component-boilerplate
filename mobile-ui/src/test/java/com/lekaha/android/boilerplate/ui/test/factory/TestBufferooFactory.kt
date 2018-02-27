package com.lekaha.android.boilerplate.ui.test.factory

import com.lekaha.android.boilerplate.presentation.model.BufferooView
import com.lekaha.android.boilerplate.ui.test.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for Bufferoo related instances
 */
class TestBufferooFactory {

    companion object Factory {

        fun makeBufferooView(): BufferooView {
            return BufferooView(randomUuid(), randomUuid(), randomUuid())
        }

    }

}