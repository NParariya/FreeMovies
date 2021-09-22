package com.example.freemovies.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.freemovies.model.FavoriteMovies


@Database(entities = [FavoriteMovies::class],version = 1,exportSchema = false)
abstract class MovieDatabase:RoomDatabase() {
    abstract fun getMovieDataDao():MovieDataDao

    companion object{
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getDataBase(context: Context?):MovieDatabase{
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                context!!.applicationContext,
                    MovieDatabase::class.java,
                    "Favorites"
                ).build()

                INSTANCE = instance

                instance
            }
        }
    }

}