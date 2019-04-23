package com.tructran.retrofitcoroutines.network

import com.tructran.retrofitcoroutines.model.PopularMoviesResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface TmdbApi {
    @GET("movie/popular")
    fun getPopularMovie(): Deferred<Response<PopularMoviesResponse>>
}