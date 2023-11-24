package com.products.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.products.presentation.navigation.ProductsNavigation
import com.products.presentation.productlist.ui.ProductListComponent
import com.products.presentation.theme.ProductsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductsNavHost()
                }
            }
        }
    }
}

@Composable
fun ProductsNavHost() {
   val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = ProductsNavigation.ProductListScreen.destination, builder = {
        composable(ProductsNavigation.ProductListScreen.destination){
            ProductListComponent()
        }

        composable(ProductsNavigation.ProductDetailScreen.destination){

        }
    })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProductsTheme {
//        Greeting("Android")
    }
}