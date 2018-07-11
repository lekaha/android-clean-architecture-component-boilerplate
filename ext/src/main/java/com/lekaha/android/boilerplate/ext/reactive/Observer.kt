package com.lekaha.android.boilerplate.ext.reactive

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * An extension collections about the [io.reactivex.Observer].
 */
fun <T> observer(): ObserverPlugin<T> = ObserverPlugin()

fun <T> observer(
    onError: (Throwable) -> Unit = {},
    onComplete: () -> Unit = {},
    onSubscribe: (Disposable) -> Unit = {},
    onNext: (T) -> Unit = {}
) =
    ObserverPlugin<T>().apply {
        onSubscribe(onSubscribe)
        onNext(onNext)
        onComplete(onComplete)
        onError(onError)
    }

class ObserverPlugin<T> : Observer<T> {
    private var _onSubscribe: ((Disposable) -> Unit)? = null
    private var _onNext: ((T) -> Unit)? = null
    private var _onComplete: (() -> Unit)? = null
    private var _onError: ((Throwable) -> Unit)? = null

    override fun onSubscribe(d: Disposable) = this._onSubscribe?.invoke(d) ?: Unit
    override fun onNext(t: T) = this._onNext?.invoke(t) ?: Unit
    override fun onComplete() = this._onComplete?.invoke() ?: Unit
    override fun onError(e: Throwable) = this._onError?.invoke(e) ?: Unit

    fun onSubscribe(onSubscribeFun: (Disposable) -> Unit): ObserverPlugin<T> =
        this.apply { _onSubscribe = onSubscribeFun }

    fun onNext(onNextFun: (t: T) -> Unit): ObserverPlugin<T> = this.apply { _onNext = onNextFun }

    fun onComplete(onCompleteFun: () -> Unit): ObserverPlugin<T> =
        this.apply { _onComplete = onCompleteFun }

    fun onError(onErrorFun: (t: Throwable) -> Unit): ObserverPlugin<T> =
        this.apply { _onError = onErrorFun }

    fun ObserverPlugin<T>.copy(): ObserverPlugin<T> = ObserverPlugin<T>().also {
        // TODO(jieyi): 8/14/17 Those functions are the same pointer as before. Duplicate the functions!
        _onSubscribe = it._onSubscribe
        _onNext = it._onNext
        _onComplete = it._onComplete
        _onError = it._onError
    }
}