package com.lekaha.android.boilerplate.ui.ext

import android.content.Context
import android.content.Intent
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity


inline fun <reified T : Any> AppCompatActivity.startForResult(
        requestCode: Int = -1,
        noinline init: Intent.() -> Unit = {}) {

    val intent = newIntent<T>(this)
    intent.init()
    startActivityForResult(intent, requestCode)
}

inline fun <reified T : Any> newIntent(context: Context) = Intent(context, T::class.java)

inline fun AppCompatActivity.transact(transactions: FragmentTransaction.() -> Unit) {
    supportFragmentManager.beginTransaction().apply { transactions() }.commit()
}