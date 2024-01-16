package com.example.cryptoappminecleanarchitecturev1.presentation.screens.coin_list_screen

import com.example.cryptoappminecleanarchitecturev1.data.local.models.transientModels.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""

)
