package com.schetckina.dogbreedapp.model.enteties

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity (tableName = "breed")
data class Breed(@PrimaryKey val label: String,
                 val parentBreed: String? = null,
                 var isFavorite: Boolean = false)