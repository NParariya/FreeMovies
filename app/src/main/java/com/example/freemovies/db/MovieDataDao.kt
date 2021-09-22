package com.example.freemovies.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.freemovies.model.FavoriteMovies
import kotlinx.coroutines.flow.Flow


@Dao
interface MovieDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieData(movie : FavoriteMovies)

    @Delete
    suspend fun removeFromFavorite(movie: FavoriteMovies)

    @Query("SELECT id FROM Favorites WHERE  id =:MovieID")
    fun exists(MovieID:Int): Int


    @Query("Select * from Favorites order by id ASC")
     fun getallMovies(): LiveData<List<FavoriteMovies>>

    // @Query()
     // suspend fun cheakIfAddedToFav(movieName: String):Flow<String>

}