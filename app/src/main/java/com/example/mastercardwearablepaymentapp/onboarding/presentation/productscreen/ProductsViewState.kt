package com.example.mastercardwearablepaymentapp.onboarding.presentation.productscreen

import com.example.mastercardwearablepaymentapp.onboarding.domain.model.Product

data class ProductsViewState  (
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)

