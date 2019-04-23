package com.tructran.retrofitcoroutines.di.module

import com.tructran.retrofitcoroutines.network.repository.MovieRepository
import com.tructran.retrofitcoroutines.network.repository.impl.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun movieRepository(impl: MovieRepositoryImpl): MovieRepository
}