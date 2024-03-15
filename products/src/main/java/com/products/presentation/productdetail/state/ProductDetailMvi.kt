package com.products.presentation.productlist.state

import com.products.presentation.base.Mvi
import com.products.presentation.model.ProductUiModel

interface ProductDetailMvi : Mvi<ProductDetailMvi.ProductDetailUiIntent, ProductDetailMvi.ProductDetailUiState, ProductDetailMvi.ProductDetailSideEffect>{

    sealed interface ProductDetailSideEffect{
    }

    sealed interface ProductDetailUiIntent{
        data class FetchProductDetail(val productId : Int) : ProductDetailUiIntent
    }

    sealed interface ProductDetailUiState{
        object Loading : ProductDetailUiState
        data class Success(val productList : ProductUiModel) :ProductDetailUiState
        data class Error(val message : String) : ProductDetailUiState
    }
}