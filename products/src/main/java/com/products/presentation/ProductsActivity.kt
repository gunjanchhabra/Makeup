package com.products.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.products.presentation.productlist.state.ProductListUiIntent
import com.products.presentation.productlist.state.ProductListUiState
import com.products.presentation.productlist.viewmodel.ProductListViewModel
import com.products.presentation.theme.ProductsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val productListViewModel = hiltViewModel<ProductListViewModel>()
            val productList = productListViewModel.productListUiState.collectAsState()
            ProductsTheme {

                LaunchedEffect(key1 = Unit) {
                    productListViewModel.onEvent(ProductListUiIntent.FetchProductList)
                }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (productList.value) {
                        is ProductListUiState.Loading -> {
                            Box(
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(50.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }

                        is ProductListUiState.Success -> {
                            val result =
                                (productList.value as ProductListUiState.Success).productList
                            Greeting(result.size.toString())
                        }

                        is ProductListUiState.Error -> {

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Text(
        text = name,
        modifier = modifier
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProductsTheme {
        Greeting("Android")
    }
}