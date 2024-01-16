package com.example.cryptoappminecleanarchitecturev1.data.remote.repositories

import com.example.cryptoappminecleanarchitecturev1.data.remote.api.CoinPaprikaApi
import com.example.cryptoappminecleanarchitecturev1.data.remote.dataSources.CoinRemoteDataSource
import com.example.cryptoappminecleanarchitecturev1.data.remote.models.dto.CoinDetailDto.CoinDetailDto
import com.example.cryptoappminecleanarchitecturev1.data.remote.models.dto.CoinDto
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinRemoteDataSource: CoinRemoteDataSource
) : CoinRepository

{
    override suspend fun getCoins(): List<CoinDto> {

        println("CoinDssssS: inside of CoinRepoImpl")
//        return emptyList<CoinDto>()
       return coinRemoteDataSource.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return coinRemoteDataSource.getCoinById(coinId = coinId)
    }
}