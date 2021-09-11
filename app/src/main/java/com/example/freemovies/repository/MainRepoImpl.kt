package com.example.freemovies.repository

import android.util.Log
import com.example.freemovies.model.MovieData
import com.example.freemovies.model.RestApis

class MainRepoImpl
    (private val apiServiceRepo: RestApis) : MainRepo {
        override suspend fun getMovie(): ArrayList<MovieData>? {
            return try {
                apiServiceRepo.getMovie()
            } catch (e: Exception) {
                Log.e("Error", e.stackTraceToString())
                null
            }
        }

    }