package com.products.presentation.navigation

sealed class ProductsNavigation(val destination : String) {
    object ProductListScreen : ProductsNavigation("Product List Screen")

    object ProductDetailScreen : ProductsNavigation("Product Detail Screen")
}