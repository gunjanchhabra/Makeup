package com.products.presentation.productlist.state

import com.domain.model.ProductDomainModel
import com.products.presentation.base.UiState

sealed class ProductListUiState : UiState{
    object Loading : ProductListUiState()
    data class Success(val productList : List<ProductDomainModel>) :ProductListUiState()
    data class Error(val message : String) : ProductListUiState()
}
