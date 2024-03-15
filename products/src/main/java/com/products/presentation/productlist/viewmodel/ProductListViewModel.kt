package com.products.presentation.productlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.model.ProductDomainModel
import com.domain.usecases.ProductListUseCase
import com.products.presentation.mapper.toUiModel
import com.products.presentation.productlist.state.ProductListMvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val productListUseCase: ProductListUseCase,
) : ViewModel(), ProductListMvi {

    private val _productListUiState = MutableStateFlow<ProductListMvi.ProductListUiState>(ProductListMvi.ProductListUiState.Loading)
    override val uiState: StateFlow<ProductListMvi.ProductListUiState>
        get() = _productListUiState

    private val _productListSideEffect = MutableSharedFlow<ProductListMvi.ProductListSideEffect>()
    override val uiSideEffect: SharedFlow<ProductListMvi.ProductListSideEffect>
        get() = _productListSideEffect

    private fun fetchProductList() {
        viewModelScope.launch {
            _productListUiState.value = ProductListMvi.ProductListUiState.Loading
            productListUseCase()
                .onSuccess {
                    onResponseSuccess(it)
                }
                .onFailure {
                    onResponseFailure(it)
                }
        }
    }

    private fun onResponseFailure(it: Throwable) {
        _productListUiState.value = ProductListMvi.ProductListUiState.Error(it.message ?: "Error")
    }

    private fun onResponseSuccess(it: List<ProductDomainModel>) {
        _productListUiState.value =
            ProductListMvi.ProductListUiState.Success(it.map { domainModel -> domainModel.toUiModel() })
    }

    override fun onSendIntent(uiIntent: ProductListMvi.ProductListUiIntent) {
        when(uiIntent){
            ProductListMvi.ProductListUiIntent.FetchProductList -> fetchProductList()
            is ProductListMvi.ProductListUiIntent.OnProductItemClick -> {
                viewModelScope.launch {
                    _productListSideEffect.emit(ProductListMvi.ProductListSideEffect.NavigateToDetailScreen(uiIntent.productId))
                }
            }
        }
    }
}