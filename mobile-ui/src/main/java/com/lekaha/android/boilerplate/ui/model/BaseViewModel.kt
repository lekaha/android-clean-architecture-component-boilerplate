package com.lekaha.android.boilerplate.ui.model

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel(), LifecycleObserver {

    val isProgressing: MutableLiveData<Boolean> = MutableLiveData()
    val occurredError: MutableLiveData<Throwable> = MutableLiveData()

    fun observeIsProgressing(owner: LifecycleOwner, block: (Boolean?) -> Unit) =
        isProgressing.observe(owner, block)

    fun observeoccurredError(owner: LifecycleOwner, block: (Throwable?) -> Unit) =
        occurredError.observe(owner, block)

    fun <T> observe(liveData: LiveData<T>, owner: LifecycleOwner, observer: (T?) -> Unit) =
        liveData.observe(owner, observer)
}

fun <T> LiveData<T>.observe(owner: LifecycleOwner, block: (T?) -> Unit) {
    observe(owner, Observer(block))
}