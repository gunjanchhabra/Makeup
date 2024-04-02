package com.products.presentation.productlist.state

import com.products.presentation.base.Mvi
import com.products.presentation.model.ProductUiModel

interface ProductListMvi :
    Mvi<ProductListMvi.ProductListUiIntent, ProductListMvi.ProductListUiState, ProductListMvi.ProductListSideEffect> {

    sealed interface ProductListSideEffect {
        data class NavigateToDetailScreen(val productId: Int) : ProductListSideEffect
    }

    sealed interface ProductListUiIntent {
        object FetchProductList : ProductListUiIntent
        data class OnProductItemClick(val productId: Int) : ProductListUiIntent
    }

    sealed interface ProductListUiState {
        object Loading : ProductListUiState
        data class Success(val productList: List<ProductUiModel>) : ProductListUiState
        data class Error(val message: String) : ProductListUiState
    }
}