package com.example.cryptoappminecleanarchitecturev1.domain.useCases

import com.example.cryptoappminecleanarchitecturev1.common.classes.UploadStatus
import com.example.cryptoappminecleanarchitecturev1.data.local.models.transientModels.Coin
import com.example.cryptoappminecleanarchitecturev1.data.local.models.transientModels.CoinDetail
import com.example.cryptoappminecleanarchitecturev1.data.remote.models.dto.CoinDetailDto.toCoinDetail
import com.example.cryptoappminecleanarchitecturev1.data.remote.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
   private val coinRepository : CoinRepository
) {
    operator fun invoke(coinId: String): Flow<UploadStatus<CoinDetail>> = flow{
        try{
            emit(UploadStatus.Loading<CoinDetail>())
            val coin = coinRepository.getCoinById(coinId).toCoinDetail()
            emit(UploadStatus.Success<CoinDetail>(coin))
        }
        catch(e: retrofit2.HttpException){
            emit(UploadStatus.Error<CoinDetail>(message = e.localizedMessage ?: "An unexpected error occured"))
        }
        catch (e: IOException){
            emit(UploadStatus.Error<CoinDetail>(message = "Couldn't reach server. Check your internet connection."))
        }
    }

}