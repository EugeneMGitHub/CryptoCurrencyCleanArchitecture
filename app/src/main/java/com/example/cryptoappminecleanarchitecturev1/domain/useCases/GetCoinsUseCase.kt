package com.example.cryptoappminecleanarchitecturev1.domain.useCases

import com.example.cryptoappminecleanarchitecturev1.common.classes.UploadStatus
import com.example.cryptoappminecleanarchitecturev1.data.local.models.transientModels.Coin
import com.example.cryptoappminecleanarchitecturev1.data.remote.models.dto.toCoin
import com.example.cryptoappminecleanarchitecturev1.data.remote.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository : CoinRepository
){

     operator fun invoke() : Flow<UploadStatus<List<Coin>>> = flow{

        try {
            emit(UploadStatus.Loading<List<Coin>>())

            val coins = coinRepository.getCoins()
                .map { it.toCoin() }
            emit(UploadStatus.Success<List<Coin>>(coins))
        }
        catch (e: retrofit2.HttpException){
            emit(UploadStatus.Error<List<Coin>>(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e : IOException){
            emit(UploadStatus.Error<List<Coin>>(message = "Couldn't reach the server. Check your internet conncetion"))
        }


    }


}