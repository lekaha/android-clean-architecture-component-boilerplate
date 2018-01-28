package com.lekaha.android.boilerplate.presentation.browse

import com.lekaha.android.boilerplate.presentation.BasePresenter
import com.lekaha.android.boilerplate.presentation.BaseView
import com.lekaha.android.boilerplate.presentation.model.BufferooView

/**
 * Defines a contract of operations between the Browse Presenter and Browse View
 */
interface BrowseBufferoosContract {

    interface View : BaseView<Presenter, List<BufferooView>>

    interface Presenter : BasePresenter {
        fun setView(view: View)
        fun retrieveBufferoos()
    }

}