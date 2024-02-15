package com.example.cryptoappminecleanarchitecturev1.presentation.screens.coin_detail_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cryptoappminecleanarchitecturev1.data.local.models.transientModels.Coin
import com.example.cryptoappminecleanarchitecturev1.data.remote.models.dto.CoinDetailDto.team
import com.example.cryptoappminecleanarchitecturev1.presentation.screens.coin_list_screen.components.CoinListItem
import com.example.cryptoappminecleanarchitecturev1.presentation.ui.theme.CryptoAppMineCleanArchitectureV1Theme

@Composable
fun TeamListItem(
    team: team,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = team.name,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = team.position,
            style = MaterialTheme.typography.bodySmall,
            fontStyle = FontStyle.Italic
        )

    }
}

@Preview(showBackground = true)
@Composable
fun ShowTeamListItem(){
    CryptoAppMineCleanArchitectureV1Theme {
        TeamListItem(
            team = team("1", "teamName", "1"),
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        )
    }
}
