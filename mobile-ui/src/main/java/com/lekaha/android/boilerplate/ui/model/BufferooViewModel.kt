package com.lekaha.android.boilerplate.ui.model

/**
 * Representation for a [BufferooViewModel] fetched from an external layer data source
 */
class BufferooViewModel(val name: String, val title: String, val avatar: String) {
    companion object {
        const val DISPLAY_TYPE_BROWSE: Int = 3
    }
}