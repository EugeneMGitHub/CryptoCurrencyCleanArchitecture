package com.example.cryptoappminecleanarchitecturev1.presentation.screens.coin_detail_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cryptoappminecleanarchitecturev1.data.remote.models.dto.CoinDetailDto.team
import com.example.cryptoappminecleanarchitecturev1.presentation.ui.theme.CryptoAppMineCleanArchitectureV1Theme

@Composable
fun CoinTag(
    tag: String
) {

    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(10.dp)
    ){
        Text(
            text = tag,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )


    }

}

@Preview(showBackground = true)
@Composable
fun ShowCoinTag(){
    CryptoAppMineCleanArchitectureV1Theme {
       CoinTag(tag = "Tag1")
    }
}