package com.example.cryptoappminecleanarchitecturev1.data.remote.api

import com.example.cryptoappminecleanarchitecturev1.data.remote.models.dto.CoinDetailDto.CoinDetailDto
import com.example.cryptoappminecleanarchitecturev1.data.remote.models.dto.CoinDto

interface CoinPaprikaApi {
   suspend fun getCoins(): List<CoinDto>
   suspend fun getCoinById(coinId: String) : CoinDetailDto
}