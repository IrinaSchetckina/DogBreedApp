package com.schetckina.dogbreedapp.breedList

import com.schetckina.dogbreedapp.model.enteties.Breed

interface OnChooseBreedListener {

    fun onChooseBreed(breed: Breed)
}