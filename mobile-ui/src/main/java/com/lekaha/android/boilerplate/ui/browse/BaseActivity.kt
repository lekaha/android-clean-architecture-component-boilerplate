package com.lekaha.android.boilerplate.ui.browse

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

open abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(getLayoutId())
        super.onCreate(savedInstanceState)
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int
}