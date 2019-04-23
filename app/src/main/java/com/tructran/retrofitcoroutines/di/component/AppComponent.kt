package com.tructran.retrofitcoroutines.di.component
import com.tructran.retrofitcoroutines.MyApplication
import com.tructran.retrofitcoroutines.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ActivityModule::class,
    ViewModelModule::class,
    NetworkModule::class,
    RepositoryModule::class,

    AndroidSupportInjectionModule::class    // must have
])
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun app(application: MyApplication): Builder
    }

}