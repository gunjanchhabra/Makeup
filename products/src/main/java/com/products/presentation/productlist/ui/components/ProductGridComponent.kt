package com.products.presentation.productlist.ui.components

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import com.products.presentation.model.ProductUiModel

@Composable
fun ProductGridComponent(
    productList: List<ProductUiModel>,
    selectedProduct: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            items(productList) { product ->
                ProductItemComponent(product = product, selectedProduct)
            }
        })
}