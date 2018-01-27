package com.lekaha.android.boilerplate.ui

import android.os.Bundle
import android.support.annotation.CallSuper
import com.lekaha.android.boilerplate.common.Preconditions

abstract class BaseInjectingActivity<Component>: BaseActivity() {
    private var component: Component? = null

    protected abstract fun createComponent(): Component?

    @CallSuper
    open protected fun onInject(component: Component) {}

    fun hasComponent(): Boolean = component != null

    fun getComponent(): Component = Preconditions[component]

    override fun onCreate(savedInstanceState: Bundle?) {
        component = createComponent()
        if (hasComponent()) {
            onInject(component!!)
        }

        super.onCreate(savedInstanceState)
    }
}