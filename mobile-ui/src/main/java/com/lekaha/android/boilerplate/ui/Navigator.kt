package com.lekaha.android.boilerplate.ui

import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.lekaha.android.boilerplate.ui.ext.transact

/**
 * Navigator is responsible for navigating as to a Fragment or a Activity
 * and dealing with transition behaviors e.g., transition animation.
 */
class Navigator constructor(var activity: BaseActivity) {

    /**
     * navigate to a Fragment with [AppCompatActivity] and the transactions
     * in [FragmentTransaction]
     */
    fun navigateTo(transactions: FragmentTransaction.() -> Unit) {
        activity.transact{
            transactions()
        }
    }
}
