package com.lekaha.android.boilerplate.ui

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import com.lekaha.android.boilerplate.domain.executor.PostExecutionThread
import javax.inject.Inject

/**
 * MainThread (UI Thread) implementation based on a [Scheduler]
 * which will execute actions on the Android UI thread
 */
class UiThread @Inject internal constructor() : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()

}