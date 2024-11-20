package com.plcoding.cryptotracker.core.domain.networking.dto

import kotlinx.serialization.Serializable

// The JSON field returned coin API, ignore unused fields
@Serializable
data class CoinDTO(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val priceUSD: Double,
    val marketCapUSD: Double,
    val changedPercent24hr: Double,
)
