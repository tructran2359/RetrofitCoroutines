package com.tructran.retrofitcoroutines.utils

import android.util.Log
import com.tructran.retrofitcoroutines.BuildConfig

val ALLOW_LOG = BuildConfig.DEBUG
const val TAG_PREFIX = "ReCo_"

fun createTag(tag: String): String {
    val newTag = TAG_PREFIX + tag
    return if (newTag.length < 23) newTag else newTag.substring(0, 23)
}

fun Any.createMessage(msg: String) = this::class.java.simpleName + " $msg"

fun Any.doLogD(tag: String, msg: String) {
    if (ALLOW_LOG) Log.d(createTag(tag), createMessage(msg))
}

fun Any.doLogE(tag: String, msg: String) {
    if (ALLOW_LOG) Log.e(createTag(tag), createMessage(msg))
}

fun Any.doLogI(tag: String, msg: String) {
    if (ALLOW_LOG) Log.i(createTag(tag), createMessage(msg))
}

fun Any.doLogThrowable(tag: String, throwable: Throwable) {
    if (ALLOW_LOG) {
        throwable.printStackTrace()
        doLogE(tag, throwable.message ?: "Empty message")
    }
}