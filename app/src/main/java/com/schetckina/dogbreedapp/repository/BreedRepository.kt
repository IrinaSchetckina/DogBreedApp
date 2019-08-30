package com.schetckina.dogbreedapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.schetckina.dogbreedapp.api.response.AllBreedResponse
import com.schetckina.dogbreedapp.api.retrofit.BreedApi
import com.schetckina.dogbreedapp.api.retrofit.BreedService
import com.schetckina.dogbreedapp.model.BreedDatabase
import com.schetckina.dogbreedapp.model.dao.BreedDao
import com.schetckina.dogbreedapp.model.enteties.Breed
import kotlinx.coroutines.*
import timber.log.Timber

class BreedRepository (private val database: BreedDatabase) {

    private  val api: BreedService = BreedApi.retrofitService

    private var job = Job()

    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    private val breedList: MutableLiveData<List<Breed>> =  MutableLiveData()

    suspend fun getFreshList(): List<Breed>? {

        return withContext(Dispatchers.Main) {
            var localData: List<Breed> = listOf()
            var result  = getDataFromNetwork()
            if (result.message.isNotEmpty()) {
                localData = saveData(result.message)


            }
            localData
        }
    }

    private suspend fun getDataFromNetwork(): AllBreedResponse {
        return withContext(Dispatchers.IO) {
            api.getAllBreadsAsync().await()
        }
    }

    private suspend fun saveData(message: Map<String, Array<String>>): List<Breed>{
        return withContext(Dispatchers.IO) {
            Timber.i("save to DB ")
            for ((breed, subBreedList) in message) {
                database.getBreedDao.addBreed(Breed(label = breed))
                if (subBreedList.isNotEmpty()) {
                    for (subBreed in subBreedList) {
                        database.getBreedDao.addBreed(Breed(label = subBreed, parentBreed = breed))
                    }
                }
            }
            database.getBreedDao.selectAll()
        }
    }

    fun getRandomImage() {

    }

    fun getAllmages() {

    }
}