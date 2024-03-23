package com.example.dictionary.di

import com.example.dictionary.data.api.DictionaryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    private var interceptor:HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    private var client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()
    @Provides
    @Singleton
    fun providesDictionaryApi() : DictionaryApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(DictionaryApi.BASE_URL)
            .client(client)
            .build()
            .create()
    }
}