package com.example.mastercardwearablepaymentapp.onboarding.domain.repository

import arrow.core.Either
import com.example.mastercardwearablepaymentapp.onboarding.domain.model.NetworkError
import com.example.mastercardwearablepaymentapp.onboarding.domain.model.Product

interface ProductsRepository {
    suspend fun getProducts(): Either<NetworkError, List<Product>>
}