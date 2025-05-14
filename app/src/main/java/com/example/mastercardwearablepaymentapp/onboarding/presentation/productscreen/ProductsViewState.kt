package com.example.mastercardwearablepaymentapp.onboarding.presentation.productscreen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mastercardwearablepaymentapp.onboarding.domain.model.Product

data class ProductsViewState  (
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)

