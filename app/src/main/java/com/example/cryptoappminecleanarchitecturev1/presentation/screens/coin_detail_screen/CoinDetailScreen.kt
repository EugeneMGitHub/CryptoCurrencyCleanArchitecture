package com.example.cryptoappminecleanarchitecturev1.presentation.screens.coin_detail_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptoappminecleanarchitecturev1.presentation.screens.coin_detail_screen.components.CoinTag
import com.example.cryptoappminecleanarchitecturev1.presentation.screens.coin_detail_screen.components.TeamListItem

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CoinDetailScreen(
    coinId: String?,
    viewModel: CoinDetailViewModel = hiltViewModel()

) {

    LaunchedEffect(key1 = Unit){
        viewModel.getCoinById(coinId!!)
    }

    val state = viewModel.state.collectAsState().value


    Box(modifier = Modifier.fillMaxSize()){
        state.coin?.let {coin->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(20.dp)
        ){

            item{

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.weight((8f))
                    )

                    Text(
                        text = if (coin.isActive) "active" else "inactive",
                        color = if (coin.isActive) Color.Green else Color.Red,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .weight(2f)
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = coin.description,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Tags",
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(modifier = Modifier.height(15.dp))
                
                FlowRow(
                    maxItemsInEachRow = 3,
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)

                ) {
                    coin.tags.forEach { tag ->
                        CoinTag(tag = tag)
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Team members",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(10.dp))

            }


          items(coin.team){teamMember->
                TeamListItem(
                    team = teamMember,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                )
              Divider()
          }





        }

        }

        if(state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }






    Text(text = "It's CoinDetailScreen and coinId is $coinId")


}