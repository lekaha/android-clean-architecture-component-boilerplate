@file:Suppress("NOTHING_TO_INLINE")

package com.lekaha.android.boilerplate.ext

inline fun Any?.isNull() = null == this

inline fun Any?.isNotNull() = null != this

/**
 * After the null check, 'this' is auto-cast to a non-null type, so the [Any.toString] below
 * resolves to the member function of the [Any] class.
 */
inline fun Any?.toString() = takeIf { it.isNotNull() }?.toString() ?: "null"
