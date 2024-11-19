package com.plcoding.cryptotracker.core.domain.util

import com.plcoding.cryptotracker.util.Error

// Implements marker Error class so we can use this enum in Result sealed interface
enum class NetworkError : Error {
    REQUEST_TIMEOUT,
    TOO_MANY_REQUESTS,
    NO_INTERNET,
    SERVER_ERROR,
    SERIALIZATION_ERROR,
    UNKNOWN
}