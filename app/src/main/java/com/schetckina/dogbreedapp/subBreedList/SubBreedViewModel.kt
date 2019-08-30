package com.schetckina.dogbreedapp.subBreedList

import androidx.lifecycle.ViewModel
import timber.log.Timber

class SubBreedViewModel : ViewModel() {

    init {
        Timber.i("create viewmodel")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("Viewmodel destroyed")
    }
}