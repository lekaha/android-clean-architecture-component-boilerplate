package com.lekaha.android.boilerplate.ui.model

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.lekaha.android.boilerplate.presentation.browse.BrowseBufferoosContract

class BrowseViewModelFactory(val presenter: BrowseBufferoosContract.Presenter)
    : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BrowseViewModel::class.java)) {
            return BrowseViewModel(presenter) as T
        }

        throw IllegalArgumentException("Illegal ViewModel class")
    }
}