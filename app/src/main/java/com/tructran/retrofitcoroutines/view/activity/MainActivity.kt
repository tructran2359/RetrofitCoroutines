package com.tructran.retrofitcoroutines.view.activity

import android.os.Bundle
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.tructran.retrofitcoroutines.R
import com.tructran.retrofitcoroutines.utils.getViewModel
import com.tructran.retrofitcoroutines.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = getViewModel(MainViewModel::class.java)

        subscribe()

        mViewModel.fetchPopularMovies()
    }

    private fun subscribe() {
        mViewModel.run {
            mPopularMovies.observe(
                    this@MainActivity,
                    Observer { movies ->
                        tv_content.text = movies?.toString() ?: "Empty"
                    }
            )

            mLoading.observe(
                    this@MainActivity,
                    Observer { loading ->
                        if (loading == null) {
                            fl_loading.isGone = true
                        } else {
                            fl_loading.isVisible = loading
                        }
                    }
            )
        }
    }

}
