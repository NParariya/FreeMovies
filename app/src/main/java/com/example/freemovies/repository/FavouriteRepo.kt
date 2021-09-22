package com.example.freemovies.repository

import androidx.lifecycle.LiveData
import com.example.freemovies.model.FavoriteMovies
import kotlinx.coroutines.flow.Flow

interface FavouriteRepo {

     fun getallMovies(): LiveData<List<FavoriteMovies>>


     fun exists(MovieID : Int):Int


    suspend fun cheakIfAddedToFav(movieName : String):Flow<String>

    suspend fun insertMovieData(movie : FavoriteMovies)

    suspend fun removeFromFavorite(movie: FavoriteMovies)


}