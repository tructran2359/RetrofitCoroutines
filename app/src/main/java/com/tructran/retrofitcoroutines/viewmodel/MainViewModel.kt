package com.tructran.retrofitcoroutines.viewmodel

import androidx.lifecycle.MutableLiveData
import com.tructran.retrofitcoroutines.model.PopularMovie
import com.tructran.retrofitcoroutines.network.repository.MovieRepository
import com.tructran.retrofitcoroutines.utils.doLogD
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val mMovieRepo: MovieRepository
): BaseViewModel() {

    fun test() {
        doLogD("Test", "Test Test")
    }

    var mPopularMovies = MutableLiveData<List<PopularMovie>>()

    fun fetchPopularMovies() {
        mLoading.value = true
        mScope.launch {
            val response = mMovieRepo.getPopularMovies()
            mPopularMovies.postValue(response?.results ?: listOf())
            mLoading.value = false
        }
    }
}