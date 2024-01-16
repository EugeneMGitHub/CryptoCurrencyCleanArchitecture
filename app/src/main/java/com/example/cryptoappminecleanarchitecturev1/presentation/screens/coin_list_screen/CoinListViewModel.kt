package com.example.cryptoappminecleanarchitecturev1.presentation.screens.coin_list_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoappminecleanarchitecturev1.common.classes.UploadStatus
import com.example.cryptoappminecleanarchitecturev1.domain.useCases.GetCoinsUseCase
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel
@Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel(){


    private val _state = MutableStateFlow<CoinListState>(CoinListState())
    val state = _state.asStateFlow()

//
//    private val _state = mutableStateOf(CoinListState())
//    val state : State<CoinListState> = _state


    init {
        getCoins()
    }



    private fun getCoins(){

        getCoinsUseCase().onEach {uploadStatus ->

        when(uploadStatus){
            is UploadStatus.Error -> {

                _state.value = CoinListState().copy(
                    error = uploadStatus.message ?:
                    "An unexpected error occurred"
                )
            }
            is UploadStatus.Loading -> {
                _state.value = CoinListState(isLoading = true)
            }
            is UploadStatus.Success -> {
                _state.value = CoinListState(coins = uploadStatus.data ?: emptyList())
            }
        }

        }.launchIn(viewModelScope)
    }



    private fun getCoins2(){

        viewModelScope.launch {
            getCoinsUseCase().onEach {uploadStatus ->

                when(uploadStatus){
                    is UploadStatus.Error -> {

                        _state.value = CoinListState().copy(
                            error = uploadStatus.message ?:
                            "An unexpected error occurred"
                        )
                    }
                    is UploadStatus.Loading -> {
                        _state.value = CoinListState(isLoading = true)
                    }
                    is UploadStatus.Success -> {
                        _state.value = CoinListState(coins = uploadStatus.data ?: emptyList())
                    }
                }

            }
        }


    }

}