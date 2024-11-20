package com.plcoding.cryptotracker.core.domain.networking

import com.plcoding.cryptotracker.core.data.networking.constructURL
import com.plcoding.cryptotracker.core.data.networking.safeCall
import com.plcoding.cryptotracker.core.domain.CoinDataSource
import com.plcoding.cryptotracker.core.domain.networking.dto.CoinResponseDTO
import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.crypto.mappers.toCoin
import com.plcoding.cryptotracker.util.Result
import com.plcoding.cryptotracker.util.map
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
) : CoinDataSource {
    override suspend fun getCoin(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinResponseDTO> {
            httpClient.get(
                urlString = constructURL("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }

}