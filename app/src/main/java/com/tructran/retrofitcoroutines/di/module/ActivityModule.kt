package com.tructran.retrofitcoroutines.di.module

import com.tructran.retrofitcoroutines.view.activity.BaseActivity
import com.tructran.retrofitcoroutines.view.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    ///////////////////////////////////////////////////////////////////////////
    // BaseActivity
    ///////////////////////////////////////////////////////////////////////////

    @ContributesAndroidInjector
    abstract fun baseActivity(): BaseActivity

    ///////////////////////////////////////////////////////////////////////////
    // MainActivity
    ///////////////////////////////////////////////////////////////////////////

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

}