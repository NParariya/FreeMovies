package com.example.freemovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freemovies.model.FavoriteMovies
import com.example.freemovies.repository.FavmovieRepoImpl
import com.example.freemovies.repository.FavouriteRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FavViewModel(private val repo: FavouriteRepo): ViewModel() {

    //lateinit var favmoviesList : LiveData<List<FavoriteMovies>>
    var favmoviesList : LiveData<List<FavoriteMovies>> = repo.getallMovies()

     /*fun getallMovies(movie: FavoriteMovies){
         viewModelScope.launch {
             repo.getallMovies()
         }
     }*/

    fun insertMovieData(movie : FavoriteMovies) {
        viewModelScope.launch {
            repo.insertMovieData(movie)
        }
    }

        fun removeFromFavorite(movie: FavoriteMovies) {
            viewModelScope.launch {
                repo.removeFromFavorite(movie)
            }
        }

        fun exists(MovieID : Int):Int{
          //  viewModelScope.launch {
            return MovieID
        }

    /* fun cheakIfAddedToFav(movieName : String):Flow<String>{
        return repo.cheakIfAddedToFav(movieName)
    }*/

}

