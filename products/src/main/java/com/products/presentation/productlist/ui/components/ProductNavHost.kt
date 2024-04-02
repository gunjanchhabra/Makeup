package com.products.presentation.productlist.ui.components

import ProductDetailComponent
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.products.R
import com.products.presentation.base.ui.BaseScreen
import com.products.presentation.navigation.ProductsNavigation

@Composable
fun ProductNavHost() {
    val navigationController = rememberNavController()
    val selectedProductID = "selected_product_id"
    NavHost(
        navController = navigationController,
        startDestination = ProductsNavigation.ProductListScreen.destination,
        builder = {
            composable(ProductsNavigation.ProductListScreen.destination) {
                BaseScreen(
                    title = stringResource(id = R.string.products),
                    isSecondaryHeader = false,
                    onBackClick = {}
                ) {
                    ProductListComponent { id ->
                        navigationController.navigate(
                            "${ProductsNavigation.ProductDetailScreen.destination}/$id"
                        )
                    }
                }
            }

            composable(
                route = "${ProductsNavigation.ProductDetailScreen.destination}/{$selectedProductID}",
                arguments = listOf(
                    navArgument(selectedProductID) {
                        type = NavType.IntType
                    }
                )
            ) {
                it.arguments?.getInt(selectedProductID)?.let { id ->
                    BaseScreen(
                        title = stringResource(id = R.string.products_detail),
                        isSecondaryHeader = true,
                        onBackClick = {
                            navigationController.navigateUp()
                        }
                    ) {
                        ProductDetailComponent(
                            productId = id
                        )
                    }
                }
            }
        })
}