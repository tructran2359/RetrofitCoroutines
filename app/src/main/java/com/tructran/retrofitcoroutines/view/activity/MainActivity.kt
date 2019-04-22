package com.tructran.retrofitcoroutines.view.activity

import android.os.Bundle
import com.tructran.retrofitcoroutines.R
import com.tructran.retrofitcoroutines.utils.getViewModel
import com.tructran.retrofitcoroutines.viewmodel.MainViewModel

class MainActivity : BaseActivity() {

    lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = getViewModel(MainViewModel::class.java)

        mViewModel.test()
    }

}
