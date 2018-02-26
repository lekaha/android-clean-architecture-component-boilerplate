package com.lekaha.android.boilerplate.remote

import com.lekaha.android.boilerplate.data.model.BufferooEntity
import com.lekaha.android.boilerplate.data.repository.BufferooRemote
import com.lekaha.android.boilerplate.remote.mapper.BufferooEntityMapper

/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BufferooRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class BufferooRemoteImpl constructor(
    private val bufferooService: BufferooService,
    private val entityMapper: BufferooEntityMapper
) :
    BufferooRemote {

    /**
     * Retrieve a list of [BufferooEntity] instances from the [BufferooService].
     */
    override fun getBufferoos() = bufferooService.getBufferoos()
        .map {
            it.team.map { listItem -> entityMapper.mapToData(listItem) }
        }

}