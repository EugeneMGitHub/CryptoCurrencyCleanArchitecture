package com.example.cryptoappminecleanarchitecturev1.data.remote.api

import com.example.cryptoappminecleanarchitecturev1.data.remote.models.dto.CoinDetailDto.CoinDetailDto
import com.example.cryptoappminecleanarchitecturev1.data.remote.models.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitCoinPaprikaApi : CoinPaprikaApi{


    @GET("v1/coins")
    override suspend fun getCoins(): List<CoinDto>

    @GET("v1/coins/{coinId}")
    override suspend fun getCoinById( @Path("coinId") coinId: String ): CoinDetailDto


}