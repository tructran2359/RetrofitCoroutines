package com.tructran.retrofitcoroutines.viewmodel

import com.tructran.retrofitcoroutines.utils.doLogD
import javax.inject.Inject

class MainViewModel @Inject constructor(): BaseViewModel() {

    fun test() {
        doLogD("Test", "Test Test")
    }
}