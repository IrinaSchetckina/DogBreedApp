package com.schetckina.dogbreedapp.breedList

import android.app.Application
import androidx.lifecycle.*
import com.schetckina.dogbreedapp.DogBreedApplication
import com.schetckina.dogbreedapp.api.retrofit.BreedApi
import com.schetckina.dogbreedapp.model.BreedDatabase
import com.schetckina.dogbreedapp.model.enteties.Breed
import com.schetckina.dogbreedapp.repository.BreedRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

class BreedListViewModel(application: Application): AndroidViewModel(application), LifecycleObserver {


    var breedList: MutableLiveData<List<Breed>> = MutableLiveData()
    private val repository: BreedRepository = BreedRepository(BreedDatabase.getDatabase(application))



    init {
        Timber.i("create viewmodel")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("Viewmodel destroyed")
    }

    fun getFreshData(): LiveData<List<Breed>> {
        Timber.i("Update current list")
        breedList.value = repository.getFreshList().value
        return breedList

    }

}
