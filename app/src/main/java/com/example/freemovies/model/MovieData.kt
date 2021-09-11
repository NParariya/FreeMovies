package com.example.freemovies.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieData(

    @SerializedName("name")
    var name: String,
    @SerializedName("life_span")
    var id: String,
    @SerializedName("breed_group")
    var group: String,
    @SerializedName("url")
    var url: String?


   /* @SerializedName("backdrop_path")
    val url : String,
    @SerializedName("title")
    var name: String,

    val belongs_to_collection: Any,
    val budget: Int,
    val genres: List<Genre>,*/

    ):Serializable