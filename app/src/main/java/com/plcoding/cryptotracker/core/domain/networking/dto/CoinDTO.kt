package com.plcoding.cryptotracker.core.domain.networking.dto

import kotlinx.serialization.Serializable

// The JSON field returned coin API, ignore unused fields
@Serializable
data class CoinDTO(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: Double,
    val priceUsd: Double,
    val changePercent24Hr: Double
)
