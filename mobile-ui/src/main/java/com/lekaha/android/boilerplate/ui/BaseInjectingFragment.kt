package com.lekaha.android.boilerplate.ui

import android.content.Context
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseInjectingFragment: Fragment() {

    abstract fun onInject()

    override fun onAttach(context: Context?) {
        onInject()
        super.onAttach(context)
    }


    @CallSuper
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int
}