package com.example.freemovies.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
data class MovieData(

    @SerializedName("name")
    var name: String,
    @SerializedName("life_span")
    var id: String,

    @SerializedName("id")
    var ids: Int,
    @SerializedName("breed_group")
    var group: String,
    @SerializedName("url")
    var url: String?,
    @SerializedName("temperament")
    var temperament : String,

    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movies: List<Movies>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("title")
    val title: String,
):Serializable