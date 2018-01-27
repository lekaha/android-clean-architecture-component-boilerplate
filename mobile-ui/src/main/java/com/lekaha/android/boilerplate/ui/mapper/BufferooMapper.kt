package com.lekaha.android.boilerplate.ui.mapper

import com.lekaha.android.boilerplate.presentation.model.BufferooView
import com.lekaha.android.boilerplate.ui.R
import com.lekaha.android.boilerplate.ui.model.BufferooViewModel
import com.lekaha.android.boilerplate.ui.model.BufferooViewModel.Companion.DISPLAY_TYPE_BROWSE
import com.lekaha.android.boilerplate.ui.view.recycler.DisplayableItem
import com.lekaha.android.boilerplate.ui.view.recycler.DisplayableItem.Companion.toDisplayableItem
import io.reactivex.Observable
import java.util.stream.Collectors.toList
import javax.inject.Inject

/**
 * Map a [BufferooView] to and from a [BufferooViewModel] instance when data is moving between
 * this layer and the Domain layer
 */
open class BufferooMapper @Inject constructor(): Mapper<BufferooViewModel, BufferooView> {

    /**
     * Map a [BufferooView] instance to a [BufferooViewModel] instance
     */
    override fun mapToViewModel(type: BufferooView): BufferooViewModel {
        return BufferooViewModel(type.name, type.title, type.avatar)
    }

    @Throws(Exception::class)
    fun mapToViewModels(views: List<BufferooView>): List<DisplayableItem<*>> {
        return Observable.fromIterable(views)
                .map { mapToViewModel(it) }
                .map { wrapInDisplayableItem(it) }
                .toList()
                .blockingGet()
    }

    private fun wrapInDisplayableItem(viewEntity: BufferooViewModel): DisplayableItem<*> {
        return toDisplayableItem(viewEntity, DISPLAY_TYPE_BROWSE)
    }
}