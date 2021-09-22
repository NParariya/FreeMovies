package com.example.freemovies.repository

import com.example.freemovies.model.MovieData
import com.example.freemovies.model.Movies

interface MainRepo {
   // suspend fun getMovie(): ArrayList<MovieData>?
    /**changed*/

    suspend fun getMovie(): MovieData?

}