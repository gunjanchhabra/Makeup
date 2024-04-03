package com.products.productDetail

import app.cash.turbine.test
import com.domain.model.ProductDomainModel
import com.domain.usecases.ProductDetailUseCase
import com.products.Dispatcher
import com.products.TestData.productDomainModel
import com.products.presentation.productdetail.state.ProductDetailMvi
import com.products.presentation.productdetail.viewmodel.ProductDetailViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductDetailViewModelTest {
    private lateinit var viewModel: ProductDetailViewModel
    private val useCase = mockk<ProductDetailUseCase>()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    var dispatcher = Dispatcher()

    @Before
    fun setup() {
        viewModel = ProductDetailViewModel(useCase)
    }

    @Test
    fun `fetchProductDetail should update state correctly on success`() = runTest {
        val productId = 1044
        val response = Result.success(productDomainModel)

        coEvery { useCase(productId) } answers { response }
        with(viewModel) {
            sendIntent(ProductDetailMvi.ProductDetailUiIntent.FetchProductDetail(productId))

            uiState.test {
                Assert.assertTrue(awaitItem() is ProductDetailMvi.ProductDetailUiState.Success)
            }
        }
    }

    @Test
    fun `fetchProductDetail should update state correctly on error`() = runTest {
        val productId = 1044
        val exception = Exception("something went wrong")
        val response = Result.failure<ProductDomainModel>(exception)

        coEvery { useCase(productId) } answers { response }

        with(viewModel) {
            sendIntent(ProductDetailMvi.ProductDetailUiIntent.FetchProductDetail(productId))

            uiState.test {
                Assert.assertTrue(awaitItem() is ProductDetailMvi.ProductDetailUiState.Error)
            }
        }

    }
}