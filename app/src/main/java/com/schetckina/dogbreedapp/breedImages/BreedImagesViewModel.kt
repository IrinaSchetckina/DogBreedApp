package com.schetckina.dogbreedapp.breedImages

import androidx.lifecycle.ViewModel
import timber.log.Timber

class BreedImagesViewModel: ViewModel() {
    init {
        Timber.i("create viewmodel")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("Viewmodel destroyed")
    }
}