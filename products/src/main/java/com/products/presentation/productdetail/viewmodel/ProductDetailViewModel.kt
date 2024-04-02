package com.products.presentation.productdetail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.usecases.ProductDetailUseCase
import com.products.presentation.mapper.toUiModel
import com.products.presentation.productdetail.state.ProductDetailMvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productDetailUseCase: ProductDetailUseCase
): ViewModel(), ProductDetailMvi {

    private val _productDetailUiState = MutableStateFlow<ProductDetailMvi.ProductDetailUiState>(
        ProductDetailMvi.ProductDetailUiState.Loading)
    override val uiState: StateFlow<ProductDetailMvi.ProductDetailUiState>
        get() = _productDetailUiState.asStateFlow()

    private val _productDetailSideEffect = MutableSharedFlow<ProductDetailMvi.ProductDetailSideEffect>()
    override val uiSideEffect: SharedFlow<ProductDetailMvi.ProductDetailSideEffect>
        get() = _productDetailSideEffect.asSharedFlow()

    override fun onSendIntent(uiIntent: ProductDetailMvi.ProductDetailUiIntent) {
        if(uiIntent is ProductDetailMvi.ProductDetailUiIntent.FetchProductDetail){
            fetchProductDetail(uiIntent.productId)
        }
    }
    private fun fetchProductDetail(productId : Int) {
        viewModelScope.launch {
            productDetailUseCase(productId)
                .onSuccess {
                    _productDetailUiState.emit(ProductDetailMvi.ProductDetailUiState.Success(it.toUiModel()))
                }
                .onFailure {
                    _productDetailUiState.emit(ProductDetailMvi.ProductDetailUiState.Error(it.message ?: ""))
                }
        }
    }
}