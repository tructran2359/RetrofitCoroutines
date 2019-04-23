package com.tructran.retrofitcoroutines.utils

import com.tructran.retrofitcoroutines.BuildConfig

fun String.needToLogHttpMessage()
        = contains(BuildConfig.BASE_API_URL)
        || isJsonString()
        || isHttpErrorString()
        || isAuthorizationHeader()

fun String.isJsonString() = this.startsWith("{") || this.startsWith("[")

fun String.isHttpErrorString() = this.contains("HTTP FAILED")

fun String.isAuthorizationHeader() = this.contains("Authorization")