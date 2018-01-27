package com.lekaha.android.boilerplate.ui

import android.os.Bundle
import android.support.annotation.LayoutRes
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity: DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(getLayoutId())
        super.onCreate(savedInstanceState)
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int
}