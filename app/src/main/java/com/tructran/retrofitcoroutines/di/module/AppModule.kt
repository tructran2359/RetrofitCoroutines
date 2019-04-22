package com.tructran.retrofitcoroutines.di.module

import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun string() = "Struc"
}