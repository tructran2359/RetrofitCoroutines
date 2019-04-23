package com.tructran.retrofitcoroutines.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

open class BaseViewModel : ViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // Coroutine
    ///////////////////////////////////////////////////////////////////////////

    private val mCoroutineContext: CoroutineContext
        get() = Dispatchers.Main

    protected val mScope: CoroutineScope = CoroutineScope(mCoroutineContext)

    override fun onCleared() {
        super.onCleared()
        cancelAllRequests()
    }

    ///////////////////////////////////////////////////////////////////////////
    // LiveData
    ///////////////////////////////////////////////////////////////////////////

    val mLoading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        mLoading.value = false
    }

    ///////////////////////////////////////////////////////////////////////////
    // Methods
    ///////////////////////////////////////////////////////////////////////////

    fun cancelAllRequests() = mCoroutineContext.cancel()
}