package com.example.mastercardwearablepaymentapp.onboarding.presentation.productscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.mastercardwearablepaymentapp.onboarding.presentation.components.LoadingDialog
import com.example.mastercardwearablepaymentapp.onboarding.presentation.components.ProductCard

@Composable
fun ProductsScreen(
    navController: NavController,
    viewModel: ProductsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ProductsContent(state = state)
}

@Composable
fun ProductsContent(
    state: ProductsViewState
) {
    LoadingDialog(isLoading = state.isLoading)
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalItemSpacing = 10.dp
    ) {
        items(state.products) {
            product ->
                ProductCard(product=product)
        }
    }

}