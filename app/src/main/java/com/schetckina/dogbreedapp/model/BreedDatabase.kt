package com.schetckina.dogbreedapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.schetckina.dogbreedapp.model.dao.BreedDao
import com.schetckina.dogbreedapp.model.enteties.Breed

@Database(entities = [Breed::class], version = 1, exportSchema = false)
abstract class BreedDatabase: RoomDatabase() {

    abstract val getBreedDao: BreedDao

    companion object {
        @Volatile
        private var INSTANCE: BreedDatabase? = null

        fun getDatabase(context: Context): BreedDatabase {
            synchronized(this ) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BreedDatabase::class.java,
                        "breed_database")
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}