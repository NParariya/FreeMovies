package com.example.freemovies.network

import com.example.freemovies.model.MovieData
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApis {

  // @GET("DevTides/DogsApi/master/dogs.json")
  // suspend fun getMovie(): ArrayList<MovieData>?

   /**changed*/
  @GET("/3/movie/popular")
  suspend fun getMovie(@Query("api_key") key : String): MovieData?



}