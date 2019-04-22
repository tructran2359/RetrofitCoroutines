package com.tructran.retrofitcoroutines.view.activity

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

@SuppressLint("Registered")
open class BaseActivity : DaggerAppCompatActivity() {

    @Inject lateinit var mViewModelFactory: ViewModelProvider.Factory

}