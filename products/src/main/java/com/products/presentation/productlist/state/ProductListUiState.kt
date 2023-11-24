package com.products.presentation.productlist.state

import com.products.presentation.base.UiState
import com.products.presentation.model.ProductUiModel

sealed class ProductListUiState : UiState{
    object Loading : ProductListUiState()
    data class Success(val productList : List<ProductUiModel>) :ProductListUiState()
    data class Error(val message : String) : ProductListUiState()
}
