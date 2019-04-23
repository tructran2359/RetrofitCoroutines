package com.tructran.retrofitcoroutines.di.module

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.tructran.retrofitcoroutines.BuildConfig
import com.tructran.retrofitcoroutines.network.TmdbApi
import com.tructran.retrofitcoroutines.utils.doLogD
import com.tructran.retrofitcoroutines.utils.needToLogHttpMessage
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        const val TIMEOUT_IN_SECOND: Long = 30
    }

    @Provides
    @Singleton
    fun authInterceptor(): Interceptor = Interceptor { chain ->
        val newUrl = chain.request().url()
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    @Provides
    @Singleton
    fun okHttpClient(authInterceptor: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()

        // Debug
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor { message ->
                if (message.needToLogHttpMessage()) {
                    doLogD("API", message)
                }
            }
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
            builder.addNetworkInterceptor(StethoInterceptor())
        }

        builder.addInterceptor(authInterceptor)
        builder.connectTimeout(TIMEOUT_IN_SECOND, TimeUnit.SECONDS)
        builder.readTimeout(TIMEOUT_IN_SECOND, TimeUnit.SECONDS)

        return builder.build()
    }

    @Provides
    @Singleton
    fun retrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BuildConfig.BASE_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun retrofitService(retrofit: Retrofit) = retrofit.create(TmdbApi::class.java)

}