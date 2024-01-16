package com.example.cryptoappminecleanarchitecturev1.presentation.screens.coin_detail_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoappminecleanarchitecturev1.common.classes.UploadStatus
import com.example.cryptoappminecleanarchitecturev1.domain.useCases.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<CoinDetailState>(CoinDetailState())
    val state = _state.asStateFlow()

    init {
//        getCoinById()
    }






        fun getCoinById(coinId: String){

               viewModelScope.launch {

                   getCoinUseCase(coinId).collect{result ->
                       when(result){
                           is UploadStatus.Error -> {
                               _state.value = CoinDetailState(error = result.message ?: "An unexpected error occured" )
                           }
                           is UploadStatus.Loading -> {
                               _state.value = CoinDetailState(isLoading = true)
                           }
                           is UploadStatus.Success -> {
                               _state.value = CoinDetailState(coin = result.data)
                           }
                       }
                   }

               }

           }



}

