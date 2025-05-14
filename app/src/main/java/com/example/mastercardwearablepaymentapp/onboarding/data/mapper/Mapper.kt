package com.example.mastercardwearablepaymentapp.onboarding.data.mapper

import coil.network.HttpException
import com.example.mastercardwearablepaymentapp.onboarding.domain.model.ApiError
import com.example.mastercardwearablepaymentapp.onboarding.domain.model.NetworkError
import java.io.IOException

fun Throwable.toNetworkError(): NetworkError {
    val error = when(this) {
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }

    return NetworkError(
        error = error,
        t = this,
    )
}