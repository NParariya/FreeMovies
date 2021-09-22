package com.example.freemovies.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName= "Favorites")
 data class FavoriteMovies (

        @PrimaryKey(autoGenerate = true)
        var id : Int = 0,

        val name : String,
        val posterPath : String


    )





