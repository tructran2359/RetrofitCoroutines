package com.tructran.retrofitcoroutines.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tructran.retrofitcoroutines.di.annotation.ViewModelKey
import com.tructran.retrofitcoroutines.viewmodel.MainViewModel
import com.tructran.retrofitcoroutines.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun mainViewModel(model: MainViewModel): ViewModel


    @Binds
    abstract fun viewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}