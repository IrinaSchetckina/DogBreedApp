package com.schetckina.dogbreedapp.randomImage

import androidx.lifecycle.ViewModel
import timber.log.Timber

class RandomImageViewModel : ViewModel() {
    init {
        Timber.i("create viewmodel")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("Viewmodel destroyed")
    }
}