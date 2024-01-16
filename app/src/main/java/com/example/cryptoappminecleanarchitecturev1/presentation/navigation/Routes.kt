package com.example.cryptoappminecleanarchitecturev1.presentation.navigation

sealed class Routes (val route: String){
    object CoinListScreen : Routes(route = "coin_list_screen")
    object CoinDetailScreen : Routes(route = "coin_detail_screen")
}