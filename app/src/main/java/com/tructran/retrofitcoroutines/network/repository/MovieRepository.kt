package com.tructran.retrofitcoroutines.network.repository

import com.tructran.retrofitcoroutines.model.PopularMoviesResponse

interface MovieRepository {
    suspend fun getPopularMovies(): PopularMoviesResponse?
}