package com.plcoding.cryptotracker.crypto.presentation.coin_list

import com.plcoding.cryptotracker.crypto.presentation.CoinUI

sealed interface CoinListAction {
    data class OnCoinClick(
        val coinUI: CoinUI,
    ) : CoinListAction

    data object OnRefresh : CoinListAction
}