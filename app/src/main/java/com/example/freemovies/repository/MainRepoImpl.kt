package com.example.freemovies.repository

import android.util.Log
import com.example.freemovies.model.MovieData
import com.example.freemovies.network.RestApis
import com.example.freemovies.network.RetroFitBuilder.apiService

class MainRepoImpl
    (private val apiServiceRepo: RestApis) : MainRepo {

    /* override suspend fun getMovie(): ArrayList<MovieData>? {
            return try {
                apiServiceRepo.getMovie()
            } catch (e: Exception) {
                Log.e("Error", e.stackTraceToString())
                null
            }
        }



   */ override suspend fun getMovie(): MovieData? {

        return try{
            apiService.getMovie("7bfb5935faa90f3b4913f80ed990bc15")
        }catch (e: java.lang.Exception){
            Log.e("Error",e.stackTraceToString())
            null
        }
    }

}