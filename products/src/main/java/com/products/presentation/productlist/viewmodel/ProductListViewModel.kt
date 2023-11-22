package com.products.presentation.productlist.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.domain.usecases.ProductListUseCase
import com.products.presentation.base.BaseViewModel
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
    private val productListUseCase: ProductListUseCase
) : BaseViewModel<ProductListUiState, ProductListUiIntent, ProductListSideEffect>() {

    private val _productListUiState = MutableStateFlow<ProductListUiState>(Loading)
    val productListUiState : StateFlow<ProductListUiState> = _productListUiState
    override fun onEvent(uiIntent: ProductListUiIntent) {
        when (uiIntent) {
            is ProductListUiIntent.FetchProductList -> {
              fetchProductList()
            }
            else -> {

            }
        }
    }

    private fun fetchProductList() {
        viewModelScope.launch {
        _productListUiState.value = Loading
            productListUseCase()
                .onSuccess {
                    // TODO map domain model to ui model
                    Log.d("Gunjan vm", it.size.toString())
                    _productListUiState.value = Success(it)
                }
                .onFailure {
                    _productListUiState.value = Error(it.message ?: "Error")
                }
        }
    }
}