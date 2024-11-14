package com.plcoding.cryptotracker.crypto.presentation.coin_list

import androidx.compose.runtime.Immutable
import com.plcoding.cryptotracker.crypto.presentation.CoinUI

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUI> = listOf<CoinUI>(),
    val selectedCoin: CoinUI? = null
)
