package com.lekaha.android.boilerplate.ui.browse

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.lekaha.android.boilerplate.presentation.browse.BrowseBufferoosContract
import com.lekaha.android.boilerplate.presentation.model.BufferooView
import com.lekaha.android.boilerplate.ui.BaseInjectingFragment
import com.lekaha.android.boilerplate.ui.R
import com.lekaha.android.boilerplate.ui.mapper.BufferooMapper
import kotlinx.android.synthetic.main.fragment_browse.*
import javax.inject.Inject

class BrowseFragment: BaseInjectingFragment(), BrowseBufferoosContract.View {

    @Inject lateinit var onboardingPresenter: BrowseBufferoosContract.Presenter
    @Inject lateinit var browseAdapter: BrowseAdapter
    @Inject lateinit var mapper: BufferooMapper

    companion object {
        fun newInstance(): BrowseFragment = BrowseFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBrowseRecycler()
        onboardingPresenter.start()
    }

    @LayoutRes
    override fun getLayoutId(): Int = R.layout.fragment_browse

    override fun setPresenter(presenter: BrowseBufferoosContract.Presenter) {
        onboardingPresenter = presenter
    }

    override fun showProgress() {
        progress.visibility = View.GONE
    }

    override fun hideProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun showBufferoos(bufferoos: List<BufferooView>) {
        browseAdapter.update(mapper.mapToViewModels(bufferoos))
        browseAdapter.notifyDataSetChanged()
        recycler_browse.visibility = View.VISIBLE
    }

    override fun hideBufferoos() {
        recycler_browse.visibility = View.VISIBLE
    }

    override fun showErrorState() {

    }

    override fun hideErrorState() {

    }

    override fun showEmptyState() {

    }

    override fun hideEmptyState() {

    }

    private fun setupBrowseRecycler() {
        recycler_browse.layoutManager = LinearLayoutManager(activity)
        recycler_browse.adapter = browseAdapter
    }
}