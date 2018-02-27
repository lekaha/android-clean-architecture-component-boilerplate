package com.lekaha.android.boilerplate.ui.injection.module

import android.content.Context
import com.lekaha.android.boilerplate.domain.executor.PostExecutionThread
import com.lekaha.android.boilerplate.domain.executor.ThreadExecutor
import com.lekaha.android.boilerplate.domain.interactor.browse.GetBufferoos
import com.lekaha.android.boilerplate.domain.repository.BufferooRepository
import com.lekaha.android.boilerplate.presentation.browse.BrowseBufferoosContract
import com.lekaha.android.boilerplate.presentation.browse.BrowseBufferoosPresenter
import com.lekaha.android.boilerplate.presentation.mapper.BufferooMapper
import com.lekaha.android.boilerplate.ui.browse.BrowseViewHolder
import com.lekaha.android.boilerplate.ui.injection.qualifier.ActivityContext
import com.lekaha.android.boilerplate.ui.model.BrowseViewModelFactory
import dagger.Module
import dagger.Provides

@Module
open class TestBrowseActivityModule {

    @Provides
    internal fun provideGetBufferoos(
        bufferooRepository: BufferooRepository,
        threadExecutor: ThreadExecutor,
        postExecutionThread: PostExecutionThread
    ) = GetBufferoos(bufferooRepository, threadExecutor, postExecutionThread)

    @Provides
    internal fun provideBufferooMapper() = BufferooMapper()

    @Provides
    internal fun provideUiBufferooMapper() =
        com.lekaha.android.boilerplate.ui.mapper.BufferooMapper()

    @Provides
    internal fun provideBrowseViewHolderFactory(@ActivityContext context: Context) =
        BrowseViewHolder.BrowseViewHolderFactory(context)

    @Provides
    internal fun provideBrowseViewHolderBinder() = BrowseViewHolder.BrowseViewHolderBinder()

    @Provides
    internal fun provideBrowsePresenter(getBufferoos: GetBufferoos, mapper: BufferooMapper)
            : BrowseBufferoosContract.Presenter = BrowseBufferoosPresenter(getBufferoos, mapper)

    @Provides
    internal fun provideBrowseViewModelFactory(presenter: BrowseBufferoosContract.Presenter) =
        BrowseViewModelFactory(presenter)
}