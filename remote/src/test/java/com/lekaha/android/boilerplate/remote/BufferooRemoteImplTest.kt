package com.lekaha.android.boilerplate.remote

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import com.lekaha.android.boilerplate.data.model.BufferooEntity
import com.lekaha.android.boilerplate.remote.mapper.BufferooEntityMapper
import com.lekaha.android.boilerplate.remote.test.factory.BufferooFactory
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BufferooRemoteImplTest {

    private lateinit var entityMapper: BufferooEntityMapper
    private lateinit var bufferooService: BufferooService

    private lateinit var bufferooRemoteImpl: BufferooRemoteImpl

    @Before
    fun setup() {
        entityMapper = mock()
        bufferooService = mock()
        bufferooRemoteImpl = BufferooRemoteImpl(bufferooService, entityMapper)
    }

    //<editor-fold desc="Get Bufferoos">
    @Test
    fun getBufferoosCompletes() {
        stubBufferooServiceGetBufferoos(Single.just(BufferooFactory.makeBufferooResponse()))
        val testObserver = bufferooRemoteImpl.getBufferoos().test()
        testObserver.assertComplete()
    }

    @Test
    fun getBufferoosReturnsData() {
        val bufferooResponse = BufferooFactory.makeBufferooResponse()
        stubBufferooServiceGetBufferoos(Single.just(bufferooResponse))
        val bufferooEntities = mutableListOf<BufferooEntity>()
        bufferooResponse.team.forEach {
            bufferooEntities.add(entityMapper.mapFromRemote(it))
        }

        val testObserver = bufferooRemoteImpl.getBufferoos().test()
        testObserver.assertValue(bufferooEntities)
    }
    //</editor-fold>

    private fun stubBufferooServiceGetBufferoos(single: Single<BufferooService.BufferooResponse>) {
        whenever(bufferooService.getBufferoos())
                .thenReturn(single)
    }
}