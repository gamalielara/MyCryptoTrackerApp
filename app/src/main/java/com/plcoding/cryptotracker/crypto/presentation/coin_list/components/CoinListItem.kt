package com.plcoding.cryptotracker.crypto.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.crypto.presentation.CoinUI
import com.plcoding.cryptotracker.crypto.presentation.toCoinUI
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme


@Composable
fun CoinListItem(
    coinUI: CoinUI,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = coinUI.iconRes),
            contentDescription = coinUI.name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(85.dp)
        )
    }
}

@Preview
@Composable
private fun CoinListItemPreview() {
    CryptoTrackerTheme {
        CoinListItem(
            coinUI = previewCoinUISample,
            onClick = {/* TODO */ }
        )
    }
}


private val previewCoinUISample = Coin(
    id = "BitCoin",
    rank = 1,
    name = "BitCoin",
    symbol = "BTC",
    marketCapUSD = 1293021818101.8,
    priceUSD = 62.90,
    changePercent24hr = 0.1
).toCoinUI()