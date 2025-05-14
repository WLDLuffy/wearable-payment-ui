package com.example.mastercardwearablepaymentapp.onboarding.data.repositoryImpl

import arrow.core.Either
import com.example.mastercardwearablepaymentapp.onboarding.data.mapper.toNetworkError
import com.example.mastercardwearablepaymentapp.onboarding.data.remote.ProductsApi
import com.example.mastercardwearablepaymentapp.onboarding.domain.model.NetworkError
import com.example.mastercardwearablepaymentapp.onboarding.domain.model.Product
import com.example.mastercardwearablepaymentapp.onboarding.domain.repository.ProductsRepository
import javax.inject.Inject

// This is where you add the implementation to the product repo interface
class ProductRepositoryImpl @Inject constructor(
    private val productsApi: ProductsApi
): ProductsRepository {

    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
        return Either.catch {
            productsApi.getProducts()
        }.mapLeft {
            it.toNetworkError()
        }
    }
}