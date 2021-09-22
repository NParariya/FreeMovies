package com.example.freemovies.repository


import androidx.lifecycle.LiveData
import com.example.freemovies.db.MovieDataDao
import com.example.freemovies.model.FavoriteMovies
import kotlinx.coroutines.flow.Flow

class FavmovieRepoImpl(private val movieDao : MovieDataDao) :FavouriteRepo {

    //val allMovies : LiveData<List<FavoriteMovies>> = movieDao.getallMovies()

    override suspend fun insertMovieData(movie :FavoriteMovies ){
        movieDao.insertMovieData(movie)
    }

     override suspend fun removeFromFavorite(movie : FavoriteMovies){
        movieDao.removeFromFavorite(movie)
    }

    override fun getallMovies(): LiveData<List<FavoriteMovies>> {
       return movieDao.getallMovies()
    }

    override fun exists(MovieID: Int): Int {
        return MovieID
    }

    override suspend fun cheakIfAddedToFav(movieName: String): Flow<String> {
        TODO("Not yet implemented")
       // return movieDao.cheakIfAddedToFav(movieName)
    }




}