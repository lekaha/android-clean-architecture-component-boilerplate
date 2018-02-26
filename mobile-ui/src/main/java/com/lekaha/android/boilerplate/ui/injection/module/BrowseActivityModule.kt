package com.lekaha.android.boilerplate.ui.injection.module

import android.content.Context
import com.lekaha.android.boilerplate.cache.BufferooCacheImpl
import com.lekaha.android.boilerplate.cache.PreferencesHelper
import com.lekaha.android.boilerplate.cache.db.DbOpenHelper
import com.lekaha.android.boilerplate.cache.mapper.BufferooEntityMapper
import com.lekaha.android.boilerplate.data.BufferooDataRepository
import com.lekaha.android.boilerplate.data.repository.BufferooCache
import com.lekaha.android.boilerplate.data.repository.BufferooRemote
import com.lekaha.android.boilerplate.data.source.BufferooCacheDataStore
import com.lekaha.android.boilerplate.data.source.BufferooDataStoreFactory
import com.lekaha.android.boilerplate.data.source.BufferooRemoteDataStore
import com.lekaha.android.boilerplate.domain.executor.PostExecutionThread
import com.lekaha.android.boilerplate.domain.executor.ThreadExecutor
import com.lekaha.android.boilerplate.domain.interactor.browse.GetBufferoos
import com.lekaha.android.boilerplate.domain.repository.BufferooRepository
import com.lekaha.android.boilerplate.presentation.browse.BrowseBufferoosContract
import com.lekaha.android.boilerplate.presentation.browse.BrowseBufferoosPresenter
import com.lekaha.android.boilerplate.presentation.mapper.BufferooMapper
import com.lekaha.android.boilerplate.remote.BufferooRemoteImpl
import com.lekaha.android.boilerplate.remote.BufferooService
import com.lekaha.android.boilerplate.ui.browse.BrowseViewHolder
import com.lekaha.android.boilerplate.ui.injection.qualifier.ActivityContext
import com.lekaha.android.boilerplate.ui.model.BrowseViewModelFactory
import dagger.Module
import dagger.Provides


/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BrowseActivityModule {

    @Provides
    internal fun provideGetBufferoos(
        bufferooRepository: BufferooRepository,
        threadExecutor: ThreadExecutor,
        postExecutionThread: PostExecutionThread
    ) = GetBufferoos(bufferooRepository, threadExecutor, postExecutionThread)

    @Provides
    internal fun provideBufferooEntityMapper() = BufferooEntityMapper()

    @Provides
    internal fun provideBufferooMapper() = com.lekaha.android.boilerplate.presentation.mapper.BufferooMapper()

    @Provides
    internal fun provideDbBufferooMapper() = com.lekaha.android.boilerplate.cache.db.mapper.BufferooMapper()

    @Provides
    internal fun provideRemoteBufferooMapper() =
        com.lekaha.android.boilerplate.remote.mapper.BufferooEntityMapper()

    @Provides
    internal fun provideDataBufferooMapper() = com.lekaha.android.boilerplate.data.mapper.BufferooMapper()

    @Provides
    internal fun provideUiBufferooMapper() = com.lekaha.android.boilerplate.ui.mapper.BufferooMapper()

    @Provides
    internal fun provideBufferooCache(
        factory: DbOpenHelper,
        entityMapper: BufferooEntityMapper,
        mapper: com.lekaha.android.boilerplate.cache.db.mapper.BufferooMapper,
        helper: PreferencesHelper
    ): BufferooCache = BufferooCacheImpl(factory, entityMapper, mapper, helper)

    @Provides
    internal fun provideBufferooRemote(
        service: BufferooService,
        factory: com.lekaha.android.boilerplate.remote.mapper.BufferooEntityMapper
    ): BufferooRemote = BufferooRemoteImpl(service, factory)

    @Provides
    internal fun provideBufferooDataStoreFactory(
        bufferooCache: BufferooCache,
        bufferooCacheDataStore: BufferooCacheDataStore,
        bufferooRemoteDataStore: BufferooRemoteDataStore
    ): BufferooDataStoreFactory = BufferooDataStoreFactory(
        bufferooCache,
        bufferooCacheDataStore,
        bufferooRemoteDataStore
    )

    @Provides
    internal fun provideBufferooCacheDataStore(bufferooCache: BufferooCache)
            : BufferooCacheDataStore = BufferooCacheDataStore(bufferooCache)

    @Provides
    internal fun provideBufferooRemoteDataStore(bufferooRemote: BufferooRemote)
            : BufferooRemoteDataStore = BufferooRemoteDataStore(bufferooRemote)

    @Provides
    internal fun provideBufferooRepository(
        factory: BufferooDataStoreFactory,
        mapper: com.lekaha.android.boilerplate.data.mapper.BufferooMapper
    ): BufferooRepository = BufferooDataRepository(factory, mapper)

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
