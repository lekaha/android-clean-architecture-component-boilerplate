package com.lekaha.android.boilerplate.common

import android.os.Looper

/**
 * Android Preconditions that having assertions for checking if the state is correct.
 */
class AndroidPreconditions {

    companion object {

        fun assertWorkerThread() {
            if (isMainThread()) {
                throw IllegalStateException(
                        "This task must be run on a worker thread and not on the Main thread.")
            }
        }

        fun assertUiThread() {
            if (!isMainThread()) {
                throw IllegalStateException(
                        "This task must be run on the Main thread and not on a worker thread.")
            }
        }

        private fun isMainThread(): Boolean =
                Looper.getMainLooper().thread == Thread.currentThread()
    }

}