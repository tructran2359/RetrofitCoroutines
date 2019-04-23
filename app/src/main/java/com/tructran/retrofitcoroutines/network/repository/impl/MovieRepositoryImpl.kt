package com.tructran.retrofitcoroutines.network.repository.impl

import com.tructran.retrofitcoroutines.model.PopularMoviesResponse
import com.tructran.retrofitcoroutines.network.TmdbApi
import com.tructran.retrofitcoroutines.network.repository.BaseRepository
import com.tructran.retrofitcoroutines.network.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    val api: TmdbApi
) : BaseRepository(), MovieRepository {

    ///////////////////////////////////////////////////////////////////////////
    // MovieRepository
    ///////////////////////////////////////////////////////////////////////////

    override suspend fun getPopularMovies(): PopularMoviesResponse? {
        val response = safeApiCall(
            call = {
                api.getPopularMovie().await()
            },
            errorMessage = "Error Fetching Popular Movies"
        )

        return response
    }
}