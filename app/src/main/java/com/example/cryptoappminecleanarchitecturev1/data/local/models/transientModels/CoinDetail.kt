package com.example.cryptoappminecleanarchitecturev1.data.local.models.transientModels

import com.example.cryptoappminecleanarchitecturev1.data.remote.models.dto.CoinDetailDto.team

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<team>
)