package com.example.freemovies.model


import com.google.gson.annotations.SerializedName

data class MoviesData(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movies: List<Movies>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)