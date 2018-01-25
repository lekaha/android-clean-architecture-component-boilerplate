package com.lekaha.android.boilerplate.ui.browse

import com.lekaha.android.boilerplate.presentation.browse.BrowseBufferoosContract
import com.lekaha.android.boilerplate.presentation.model.BufferooView
import com.lekaha.android.boilerplate.ui.BaseInjectingFragment
import javax.inject.Inject

class BrowseFragment: BaseInjectingFragment(), BrowseBufferoosContract.View {

    @Inject lateinit var browseAdapter: BrowseAdapter

    companion object {
        fun newInstance(): BrowseFragment = BrowseFragment()
    }

    override fun onInject() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPresenter(presenter: BrowseBufferoosContract.Presenter) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showBufferoos(bufferoos: List<BufferooView>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideBufferoos() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideErrorState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmptyState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideEmptyState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}