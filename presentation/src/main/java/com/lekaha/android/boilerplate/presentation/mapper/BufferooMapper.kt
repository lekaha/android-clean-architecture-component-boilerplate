package com.lekaha.android.boilerplate.presentation.mapper

import com.lekaha.android.boilerplate.domain.model.Bufferoo
import com.lekaha.android.boilerplate.presentation.model.BufferooView

/**
 * Map a [BufferooView] to and from a [Bufferoo] instance when data is moving between
 * this layer and the Domain layer
 */
open class BufferooMapper : Mapper<BufferooView, Bufferoo> {

    /**
     * Map a [Bufferoo] instance to a [BufferooView] instance
     */
    override fun mapToView(type: Bufferoo): BufferooView {
        return BufferooView(type.name, type.title, type.avatar)
    }


}