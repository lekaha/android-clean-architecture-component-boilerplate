package com.lekaha.android.boilerplate.ui

import android.content.Context
import android.support.annotation.CallSuper

abstract class BaseInjectingFragment: BaseFragment() {

    @CallSuper
    open protected fun onInject() {}

    override fun onAttach(context: Context?) {
        onInject()
        super.onAttach(context)
    }
}