package com.example.cryptoappminecleanarchitecturev1.data.remote.dataSources

import com.example.cryptoappminecleanarchitecturev1.data.remote.api.CoinPaprikaApi
import com.example.cryptoappminecleanarchitecturev1.data.remote.models.dto.CoinDetailDto.CoinDetailDto
import com.example.cryptoappminecleanarchitecturev1.data.remote.models.dto.CoinDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CoinRemoteDataSource @Inject constructor(
    private val coinPaprikaApi: CoinPaprikaApi,
//    private val ioDispatcher: CoroutineDispatcher = Dispatchers.Default
) {


   suspend fun getCoins() : List<CoinDto>{

//       withContext()
        println("CoinDssssS: inside of CoinRemoteDataSource")
        return coinPaprikaApi.getCoins()
//        return emptyList<CoinDto>()
    }

   suspend fun getCoinById(coinId: String): CoinDetailDto {
        return coinPaprikaApi.getCoinById(coinId = coinId)
    }



}