package com.lekaha.android.boilerplate.presentation

class ViewResponse<T>(var status: Status, var data: T?, var error: Throwable?) {

    companion object {
        fun <T> loading() = ViewResponse<T>(Status.LOADING, null, null)

        fun <T> error(error: Throwable) = ViewResponse<T>(Status.ERROR, null, error)

        fun <T> success(data: T) = ViewResponse(Status.SUCCESS, data, null)
    }

    enum class Status {
        LOADING,
        SUCCESS,
        ERROR
    }
}