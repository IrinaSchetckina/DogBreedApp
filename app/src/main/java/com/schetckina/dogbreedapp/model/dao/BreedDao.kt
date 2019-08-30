package com.schetckina.dogbreedapp.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.schetckina.dogbreedapp.model.enteties.Breed
import kotlinx.coroutines.Deferred

@Dao
interface BreedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBreed(breed: Breed)

    @Query("SELECT * FROM breed ORDER BY label ASC")
    suspend fun selectAll(): List<Breed>

    @Query("SELECT * FROM breed WHERE label=:label")
    suspend fun getBreed(label: String): Breed

    @Query("SELECT * FROM breed WHERE isFavorite = 1")
    suspend fun getFavorite(): List<Breed>

    @Delete
    suspend fun delete(breed: Breed)





}