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
import com.products.presentation.productdetail.viewmodel.ProductDetailViewModel
import com.products.presentation.productdetail.state.ProductDetailMvi
import com.products.presentation.productdetail.ui.ProductDetailCardComponent

@Composable
fun ProductDetailComponent(productId: Int) {
    val viewModel: ProductDetailViewModel = hiltViewModel()
    val result by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit, block = {
        viewModel.sendIntent(
            ProductDetailMvi.ProductDetailUiIntent.FetchProductDetail(productId)
        )
    })


    when (result) {
        is ProductDetailMvi.ProductDetailUiState.Error -> {
            Toast.makeText(
                context,
                (result as ProductDetailMvi.ProductDetailUiState.Error).message,
                Toast.LENGTH_SHORT
            ).show()

        }

        is ProductDetailMvi.ProductDetailUiState.Loading -> {
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

        is ProductDetailMvi.ProductDetailUiState.Success -> {
            val product = (result as ProductDetailMvi.ProductDetailUiState.Success).product
            ProductDetailCardComponent(product = product)
        }
    }
}
