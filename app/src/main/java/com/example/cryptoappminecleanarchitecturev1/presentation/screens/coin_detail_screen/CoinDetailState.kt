package com.example.cryptoappminecleanarchitecturev1.presentation.screens.coin_detail_screen

import com.example.cryptoappminecleanarchitecturev1.data.local.models.transientModels.CoinDetail

data class CoinDetailState (
    val isLoading: Boolean = false,
    val coin : CoinDetail? = null,
    val error: String = ""
)