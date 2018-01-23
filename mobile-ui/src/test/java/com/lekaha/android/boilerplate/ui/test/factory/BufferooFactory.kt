package org.buffer.android.boilerplate.ui.test.factory

import com.lekaha.android.boilerplate.presentation.model.BufferooView
import org.buffer.android.boilerplate.ui.test.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for Bufferoo related instances
 */
class BufferooFactory {

    companion object Factory {

        fun makeBufferooView(): BufferooView {
            return BufferooView(randomUuid(), randomUuid(), randomUuid())
        }

    }

}