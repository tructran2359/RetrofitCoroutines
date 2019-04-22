package com.tructran.retrofitcoroutines.utils

import androidx.lifecycle.ViewModelProviders
import com.tructran.retrofitcoroutines.view.activity.BaseActivity
import com.tructran.retrofitcoroutines.viewmodel.BaseViewModel

inline fun <reified T: BaseViewModel> BaseActivity.getViewModel(ofClass: Class<T>): T {
    return ViewModelProviders.of(this).get(ofClass)
}