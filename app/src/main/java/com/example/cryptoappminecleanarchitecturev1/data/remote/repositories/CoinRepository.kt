package com.example.cryptoappminecleanarchitecturev1.data.remote.repositories

import com.example.cryptoappminecleanarchitecturev1.data.remote.models.dto.CoinDetailDto.CoinDetailDto
import com.example.cryptoappminecleanarchitecturev1.data.remote.models.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}