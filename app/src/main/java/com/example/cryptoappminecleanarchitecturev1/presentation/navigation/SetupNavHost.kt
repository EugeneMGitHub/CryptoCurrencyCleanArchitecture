package com.example.cryptoappminecleanarchitecturev1.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cryptoappminecleanarchitecturev1.data.local.models.transientModels.Coin
import com.example.cryptoappminecleanarchitecturev1.presentation.screens.coin_detail_screen.CoinDetailScreen
import com.example.cryptoappminecleanarchitecturev1.presentation.screens.coin_list_screen.CoinListScreen


@Composable
fun SetupNavHost (){

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = Routes.CoinListScreen.route
    ){

        composable(
            route = Routes.CoinListScreen.route
        ){
            CoinListScreen(
                onItemClick =  {coin: Coin ->
                    navController.navigate(Routes.CoinDetailScreen.route + "/${coin.id}")
                }

            )


        }

        composable(
            route = Routes.CoinDetailScreen.route + "/{coinId}",
            arguments = listOf(
                navArgument(name = "coinId"){
                    type = NavType.StringType
//                    defaultValue = "1"
//                    nullable = false
                }
            )
        ){ entry ->
            val coinId = entry.arguments?.getString("coinId")
            CoinDetailScreen(
                coinId = coinId
            )
        }

    }



}