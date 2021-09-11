package com.example.freemovies.model

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestApis {

   @GET("DevTides/DogsApi/master/dogs.json")
     suspend fun getMovie(): ArrayList<MovieData>?



 /*@GET("movie/popular?api_key=22f98a74039b606c9dd1e4a47df1eb07")
  suspend fun getMovie( ): ArrayList<MovieData>?*/
}