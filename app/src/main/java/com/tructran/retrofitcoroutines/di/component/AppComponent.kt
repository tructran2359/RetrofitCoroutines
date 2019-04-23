package com.tructran.retrofitcoroutines.di.component
import com.tructran.retrofitcoroutines.MyApplication
import com.tructran.retrofitcoroutines.di.module.ActivityModule
import com.tructran.retrofitcoroutines.di.module.AppModule
import com.tructran.retrofitcoroutines.di.module.NetworkModule
import com.tructran.retrofitcoroutines.di.module.ViewModelModule
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