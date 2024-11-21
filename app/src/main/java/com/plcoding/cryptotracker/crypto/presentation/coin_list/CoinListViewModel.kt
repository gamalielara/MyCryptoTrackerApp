package com.plcoding.cryptotracker.crypto.presentation.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptotracker.core.domain.CoinDataSource
import com.plcoding.cryptotracker.crypto.presentation.toCoinUI
import com.plcoding.cryptotracker.util.onError
import com.plcoding.cryptotracker.util.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CoinListViewModel(
    private val coinDataSource: CoinDataSource
) : ViewModel() {
    private val _state = MutableStateFlow(CoinListState())

    // OnStart runs when the compose UI starts subscribing to this viewModel
    val state = _state
        .onStart {
            loadCoins()
        }.stateIn(
            viewModelScope,
            /** Keep executing this flow (loadCoins) as long as there is no subscriber for 5+ sec
             *  When there is no subscriber listens to the state, wait for for 5+s, if there is still no subscriber, stop this execution of flow chain
             *  Useful to not re-execute and recollect this flow when there's configuration change which makes activity is destroyed
             */
            SharingStarted.WhileSubscribed(5000L),
            CoinListState(),
        )

    /**
     * Basically we can also use init {} so when the viewModel is called, the loadCoins func is executed
     * Downside: hard for testing since we don't know for sure when the loadCoins is executed
     *
     * init {
     *    loadCoins()
     * }
     */


    private fun loadCoins() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            coinDataSource
                .getCoin()
                .onSuccess { coins ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            coins = coins.map { it.toCoinUI() })
                    }
                }
                .onError { error ->
                    _state.update {
                        it.copy(isLoading = false)
                    }
                }
        }
    }

    fun onAction(action: CoinListAction) {
        when (action) {
            is CoinListAction.OnCoinClick -> {}
            is CoinListAction.OnRefresh -> {
                TODO("Will not be implemented for now.")
            }
        }
    }

}