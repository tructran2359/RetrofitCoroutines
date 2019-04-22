package com.tructran.retrofitcoroutines.di.component

import com.tructran.retrofitcoroutines.MyApplication
import com.tructran.retrofitcoroutines.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,


    AndroidSupportInjectionModule::class    // must have
])
interface AppComponent : AndroidInjector<dagger.android.support.DaggerApplication> {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun app(application: MyApplication): Builder
    }
}