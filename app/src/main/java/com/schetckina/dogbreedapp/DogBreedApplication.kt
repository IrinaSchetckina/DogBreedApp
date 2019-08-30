package com.schetckina.dogbreedapp

import android.app.Application
import timber.log.Timber

class DogBreedApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}