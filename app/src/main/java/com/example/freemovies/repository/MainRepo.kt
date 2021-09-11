package com.example.freemovies.repository

import com.example.freemovies.model.MovieData

interface MainRepo {
    suspend fun getMovie(): ArrayList<MovieData>?
}