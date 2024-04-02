package com.products.presentation.productlist.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.products.presentation.productlist.state.ProductListMvi
import com.products.presentation.productlist.ui.viewmodel.ProductListViewModel

@Composable
fun ProductListComponent(
    viewModel: ProductListViewModel = hiltViewModel(),
    selectedProduct: (Int) -> Unit
) {
    val result by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit, block = {
        viewModel.uiSideEffect.collect {
            if (it is ProductListMvi.ProductListSideEffect.NavigateToDetailScreen) {
                selectedProduct(it.productId)
            }
        }
    })


    when (result) {
        is ProductListMvi.ProductListUiState.Error -> {
            Toast.makeText(
                context,
                (result as ProductListMvi.ProductListUiState.Error).message,
                Toast.LENGTH_SHORT
            ).show()

        }

        is ProductListMvi.ProductListUiState.Loading -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                )
            }
        }

        is ProductListMvi.ProductListUiState.Success -> {
            val value = (result as ProductListMvi.ProductListUiState.Success).productList
            ProductGridComponent(productList = value, selectedProduct)
        }
    }
}

