package com.plcoding.cryptotracker.crypto.presentation

import android.icu.text.NumberFormat
import androidx.annotation.DrawableRes
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.util.getDrawableIdForCoin
import java.util.Locale

data class CoinUI(
    
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUSD: DisplayableNumber,
    val priceUSD: DisplayableNumber,
    val changePercent24hr: DisplayableNumber,
    @DrawableRes val iconRes: Int
)

data class DisplayableNumber(
    val value: Double,
    val formatted: String
)

fun Coin.toCoinUI(): CoinUI {
    return CoinUI(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        priceUSD = priceUSD.toDisplayableNumber(),
        marketCapUSD = marketCapUSD.toDisplayableNumber(),
        changePercent24hr = changePercent24hr.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}

fun Double.toDisplayableNumber(): DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }

    return DisplayableNumber(
        value = this,
        formatted = formatter.format(this)
    )
}
