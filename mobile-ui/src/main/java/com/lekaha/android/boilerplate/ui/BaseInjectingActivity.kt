package com.lekaha.android.boilerplate.ui

import com.lekaha.android.boilerplate.common.Preconditions
import com.lekaha.android.boilerplate.ui.browse.BaseActivity

abstract class BaseInjectingActivity<Component>: BaseActivity() {
    private var component: Component? = null

    protected abstract fun createComponent(): Component

    protected abstract fun onInject(component: Component)

    fun getComponent(): Component = Preconditions.get(component)
}