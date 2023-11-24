package com.products.presentation.productlist.viewmodel

import androidx.lifecycle.viewModelScope
import com.domain.model.ProductDomainModel
import com.domain.usecases.ProductListUseCase
import com.products.presentation.base.BaseViewModel
import com.products.presentation.mapper.ProductUiMapper
import com.products.presentation.productlist.state.ProductListSideEffect
import com.products.presentation.productlist.state.ProductListUiIntent
import com.products.presentation.productlist.state.ProductListUiState
import com.products.presentation.productlist.state.ProductListUiState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val productListUseCase: ProductListUseCase,
    private val productUiMapper: ProductUiMapper
) : BaseViewModel<ProductListUiState, ProductListUiIntent, ProductListSideEffect>() {

    private val _productListUiState = MutableStateFlow<ProductListUiState>(Loading)
    val productListUiState: StateFlow<ProductListUiState> = _productListUiState
    override fun onEvent(uiIntent: ProductListUiIntent) {
        when (uiIntent) {
            is ProductListUiIntent.FetchProductList -> {
                fetchProductList()
            }
            is ProductListUiIntent.OnProductItemClick ->{

            }
        }
    }

    private fun fetchProductList() {
        viewModelScope.launch {
            _productListUiState.value = Loading
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
        _productListUiState.value = Error(it.message ?: "Error")
    }

    private fun onResponseSuccess(it: List<ProductDomainModel>) {
        _productListUiState.value =
            Success(it.map { domainModel -> productUiMapper.map(domainModel) })
    }
}