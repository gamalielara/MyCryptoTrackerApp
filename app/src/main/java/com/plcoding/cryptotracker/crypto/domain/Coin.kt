// Domain package consist of independent isolated processes (not depend on external parties like API, etc)
// e.g. business logic
package com.plcoding.cryptotracker.crypto.domain

data class Coin(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUSD: Double,
    val priceUSD: Double,
    val changePercent24hr: Double,
)