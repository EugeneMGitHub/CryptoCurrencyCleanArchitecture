package com.example.cryptoappminecleanarchitecturev1.presentation.screens.coin_list_screen.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cryptoappminecleanarchitecturev1.data.local.models.transientModels.Coin
import com.example.cryptoappminecleanarchitecturev1.presentation.Greeting
import com.example.cryptoappminecleanarchitecturev1.presentation.ui.theme.CryptoAppMineCleanArchitectureV1Theme

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: () -> Unit

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = if(coin.isActive)"active" else "inactive",
            color = if(coin.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.align(CenterVertically)
        )

    }


}


@Preview(showBackground = true)
@Composable
fun CoinListItemPreview() {
    CryptoAppMineCleanArchitectureV1Theme {
        CoinListItem(
            coin = Coin("1",true,"CoinName",3,"S"),
            onItemClick = {})
    }
}
