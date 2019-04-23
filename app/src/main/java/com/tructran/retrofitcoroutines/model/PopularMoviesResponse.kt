package com.tructran.retrofitcoroutines.model

import com.google.gson.annotations.SerializedName

data class PopularMoviesResponse (

    val page: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int,
    val results: List<PopularMovie>?
)

data class PopularMovie(

    val id: Int,

    val title: String?,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("original_title")
    val originalTitle: String?,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    val overview: String?,

    @SerializedName("release_date")
    val releaseDate: String?
)