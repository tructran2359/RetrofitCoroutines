package com.tructran.retrofitcoroutines.network.repository

import com.tructran.retrofitcoroutines.utils.doLogThrowable
import retrofit2.Response
import java.io.IOException

open class BaseRepository {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, errorMessage: String): T? {
        val result = safeApiResult(call, errorMessage)

        return when(result) {
            is Result.Success -> {
                result.data
            }
            is Result.Error -> {
                doLogThrowable("API", result.exception)
                null
            }
        }
    }

    private suspend fun <T: Any> safeApiResult(call: suspend ()-> Response<T>, errorMessage: String) : Result<T>{
        val response = call.invoke()
        if(response.isSuccessful) return Result.Success(response.body()!!)

        return Result.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - $errorMessage"))
    }
}

sealed class Result<out T: Any> {
    data class Success<out T: Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}