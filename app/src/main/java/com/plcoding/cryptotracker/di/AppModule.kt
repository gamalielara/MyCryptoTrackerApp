package com.plcoding.cryptotracker.di

import com.plcoding.cryptotracker.core.data.networking.HttpClientFactory
import com.plcoding.cryptotracker.core.domain.CoinDataSource
import com.plcoding.cryptotracker.core.domain.networking.RemoteCoinDataSource
import com.plcoding.cryptotracker.crypto.presentation.coin_list.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    // get -> Koin will find every module and see which module that can injected to the constructor `RemoteCoinDataSource`
    // single { RemoteCoinDataSource(get()) }

    // Delegate the call of the singleOf function to the RemoteCoinDataSource
    // No need to pass constructor arguments in RemoteCoinDataSource
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)
}