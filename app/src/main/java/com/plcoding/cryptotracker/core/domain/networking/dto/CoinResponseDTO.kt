package com.plcoding.cryptotracker.core.domain.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinResponseDTO(
    val data: List<CoinDTO>
)
