package com.example.mastercardwearablepaymentapp.onboarding.data.remote

import com.example.mastercardwearablepaymentapp.onboarding.domain.model.Product
import retrofit2.http.GET


// add interface to api layer here
interface ProductsApi {
    @GET("/products")
    suspend fun getProducts(): List<Product>
}