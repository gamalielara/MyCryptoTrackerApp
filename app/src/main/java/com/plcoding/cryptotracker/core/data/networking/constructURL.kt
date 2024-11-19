package com.plcoding.cryptotracker.core.data.networking

import com.plcoding.cryptotracker.BuildConfig

fun constructURL(url: String): String = when {
    url.contains(BuildConfig.BASE_URL) -> url
    url.startsWith("/") -> "${BuildConfig.BASE_URL}${url.drop(1)}"
    else -> "${BuildConfig.BASE_URL}${url}"
}