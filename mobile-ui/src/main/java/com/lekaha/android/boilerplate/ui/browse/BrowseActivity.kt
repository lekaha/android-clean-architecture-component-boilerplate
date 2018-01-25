package com.lekaha.android.boilerplate.ui.browse

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.lekaha.android.boilerplate.presentation.browse.BrowseBufferoosContract
import com.lekaha.android.boilerplate.presentation.model.BufferooView
import com.lekaha.android.boilerplate.ui.BaseInjectingActivity
import com.lekaha.android.boilerplate.ui.BufferooApplication
import com.lekaha.android.boilerplate.ui.R
import com.lekaha.android.boilerplate.ui.R.id.progress
import com.lekaha.android.boilerplate.ui.R.id.recycler_browse
import com.lekaha.android.boilerplate.ui.injection.module.ActivityBindingModule_BindMainActivity
import com.lekaha.android.boilerplate.ui.mapper.BufferooMapper
import dagger.android.AndroidInjection
import javax.inject.Inject

class BrowseActivity:
        BaseInjectingActivity<ActivityBindingModule_BindMainActivity.BrowseActivitySubcomponent>(),
        BrowseBufferoosContract.View {

    override fun createComponent(): ActivityBindingModule_BindMainActivity.BrowseActivitySubcomponent {
        var app = BufferooApplication::class.java.cast(application)
//        app.
//        BrowseActivityModule()
    }

    override fun onInject(component: ActivityBindingModule_BindMainActivity.BrowseActivitySubcomponent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject lateinit var onboardingPresenter: BrowseBufferoosContract.Presenter
    @Inject lateinit var browseAdapter: BrowseAdapter
    @Inject lateinit var mapper: BufferooMapper

    override fun setPresenter(presenter: BrowseBufferoosContract.Presenter) {
        onboardingPresenter = presenter
    }

    override fun hideProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun showProgress() {
        progress.visibility = View.GONE
    }

    override fun showBufferoos(bufferoos: List<BufferooView>) {
        browseAdapter.bufferoos = bufferoos.map { mapper.mapToViewModel(it) }
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)
        AndroidInjection.inject(this)
        setupBrowseRecycler()
    }

    override fun onStart() {
        super.onStart()
        onboardingPresenter.start()
    }

    private fun setupBrowseRecycler() {
        recycler_browse.layoutManager = LinearLayoutManager(this)
        recycler_browse.adapter = browseAdapter
    }

}