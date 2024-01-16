package com.example.cryptoappminecleanarchitecturev1.domain.di

import com.example.cryptoappminecleanarchitecturev1.common.constants.Constants.BASE_URL
import com.example.cryptoappminecleanarchitecturev1.data.remote.api.CoinPaprikaApi
import com.example.cryptoappminecleanarchitecturev1.data.remote.api.RetrofitCoinPaprikaApi
import com.example.cryptoappminecleanarchitecturev1.data.remote.dataSources.CoinRemoteDataSource
import com.example.cryptoappminecleanarchitecturev1.data.remote.repositories.CoinRepository
import com.example.cryptoappminecleanarchitecturev1.data.remote.repositories.CoinRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {

        val okHttpClient = OkHttpClient.Builder().build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun provideCoinPaprikaApi(retrofit: Retrofit) : CoinPaprikaApi {
        return retrofit.create(RetrofitCoinPaprikaApi::class.java)
    }


    @Provides
    @Singleton
    fun provideCoinRemoteDataSource(coinPaprikaApi : CoinPaprikaApi) : CoinRemoteDataSource {
        return CoinRemoteDataSource(coinPaprikaApi = coinPaprikaApi)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(coinRemoteDataSource: CoinRemoteDataSource) : CoinRepository {
        return CoinRepositoryImpl(coinRemoteDataSource = coinRemoteDataSource)
    }





}