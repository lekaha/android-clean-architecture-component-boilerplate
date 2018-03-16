package com.playone.mobile.ext

inline fun Boolean?.ifTrue(block: () -> Unit): Boolean {

    if (true == this) {
        block()
        return true
    }

    return false
}

inline fun Boolean?.ifFalse(block: () -> Unit): Boolean {

    if (true == this) {
        return false
    }

    block()
    return true
}

inline infix fun Boolean.otherwise(block: () -> Unit) {

    if (this.not()) {
        block()
    }
}