package com.plcoding.cryptotracker.crypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val _contentColor = if (isSystemInDarkTheme()) {
        Color.White
    } else {
        Color.Black
    }

    Row(
        modifier = modifier
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
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = coinUI.symbol,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = _contentColor
            )
            Text(
                text = coinUI.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = _contentColor
            )
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = "$ ${coinUI.priceUSD.formatted}",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = _contentColor
            )
            Spacer(
                modifier = Modifier.height(8.dp),
            )
            PrizeChanged(
                change = coinUI.changePercent24hr,
            )
        }
    }
}

@Preview
@Composable
@PreviewLightDark
private fun CoinListItemPreview() {
    CryptoTrackerTheme {
        CoinListItem(
            coinUI = previewCoinUISample,
            onClick = {/* TODO */ },
            modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)
        )
    }
}


val previewCoinUISample = Coin(
    id = "BitCoin",
    rank = 1,
    name = "BitCoin",
    symbol = "BTC",
    marketCapUSD = 1293021818101.8,
    priceUSD = 62.90,
    changePercent24hr = 0.1
).toCoinUI()