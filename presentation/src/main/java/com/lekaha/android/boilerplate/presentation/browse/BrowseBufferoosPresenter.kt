package com.lekaha.android.boilerplate.presentation.browse

import com.lekaha.android.boilerplate.domain.interactor.SingleUseCase
import com.lekaha.android.boilerplate.domain.model.Bufferoo
import com.lekaha.android.boilerplate.presentation.ViewResponse
import com.lekaha.android.boilerplate.presentation.mapper.BufferooMapper
import io.reactivex.observers.DisposableSingleObserver

class BrowseBufferoosPresenter constructor(
    val getBufferoosUseCase: SingleUseCase<List<Bufferoo>, Void>,
    val bufferooMapper: BufferooMapper
) :
    BrowseBufferoosContract.Presenter {

    var browseView: BrowseBufferoosContract.View? = null

    override fun setView(view: BrowseBufferoosContract.View) {
        browseView = view
    }

    override fun start() {
        retrieveBufferoos()
        browseView?.onResponse(ViewResponse.loading())
    }

    override fun stop() {
        getBufferoosUseCase.dispose()
    }

    override fun retrieveBufferoos() {
        getBufferoosUseCase.execute(BufferooSubscriber())
    }

    internal fun handleGetBufferoosSuccess(bufferoos: List<Bufferoo>) {
        browseView?.onResponse(ViewResponse.success(bufferoos.map {
            bufferooMapper.mapToView(it)
        }))
    }

    inner class BufferooSubscriber : DisposableSingleObserver<List<Bufferoo>>() {

        override fun onSuccess(t: List<Bufferoo>) {
            handleGetBufferoosSuccess(t)
        }

        override fun onError(exception: Throwable) {
            browseView?.onResponse(ViewResponse.error(exception))
        }

    }

}