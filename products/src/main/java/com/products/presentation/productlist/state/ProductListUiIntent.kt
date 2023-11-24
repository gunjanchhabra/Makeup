package com.products.presentation.productlist.state

import com.products.presentation.base.UiIntent

sealed interface ProductListUiIntent : UiIntent{
    object FetchProductList : ProductListUiIntent
    object OnProductItemClick : ProductListUiIntent
}
