package com.plcoding.cryptotracker.crypto.mappers

import com.plcoding.cryptotracker.core.domain.networking.dto.CoinDTO
import com.plcoding.cryptotracker.crypto.domain.Coin

fun CoinDTO.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        symbol = symbol,
        marketCapUSD = marketCapUsd,
        priceUSD = priceUsd,
        changePercent24hr = changePercent24Hr,
        name = name,
    )
}
