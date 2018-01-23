package com.lekaha.android.boilerplate.presentation.browse

import com.lekaha.android.boilerplate.presentation.BasePresenter
import com.lekaha.android.boilerplate.presentation.BaseView
import com.lekaha.android.boilerplate.presentation.model.BufferooView

/**
 * Defines a contract of operations between the Browse Presenter and Browse View
 */
interface BrowseBufferoosContract {

    interface View : BaseView<Presenter> {

        fun showProgress()

        fun hideProgress()

        fun showBufferoos(bufferoos: List<BufferooView>)

        fun hideBufferoos()

        fun showErrorState()

        fun hideErrorState()

        fun showEmptyState()

        fun hideEmptyState()

    }

    interface Presenter : BasePresenter {

        fun retrieveBufferoos()

    }

}