package com.products.productList

import app.cash.turbine.test
import com.domain.model.ProductDomainModel
import com.domain.usecases.ProductListUseCase
import com.products.Dispatcher
import com.products.TestData.errorString
import com.products.TestData.productDomainModel
import com.products.presentation.productlist.state.ProductListMvi
import com.products.presentation.productlist.ui.viewmodel.ProductListViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductListViewModelTest {

    private lateinit var viewModel: ProductListViewModel
    private val useCase = mockk<ProductListUseCase>()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    var dispatcher = Dispatcher()

//    @Before
//    fun setup() {
//        viewModel = ProductListViewModel(useCase)
//    }

    @Test
    fun `fetchProductList should update state correctly on success`() = runTest {
        val successResponse = Result.success(mutableListOf(productDomainModel))
        coEvery { useCase() } answers { successResponse }
        viewModel = ProductListViewModel(useCase)
        with(viewModel) {
            onSendIntent(ProductListMvi.ProductListUiIntent.FetchProductList)

            uiState.test {
                Assert.assertTrue(awaitItem() is ProductListMvi.ProductListUiState.Success)
            }
        }

    }

    @Test
    fun `fetchProductList should update state correctly on error`() = runTest {
        val exception = Exception(errorString)
        val response = Result.failure<List<ProductDomainModel>>(exception)
        coEvery { useCase() } answers { response }
        viewModel = ProductListViewModel(useCase)
        with(viewModel) {
            onSendIntent(ProductListMvi.ProductListUiIntent.FetchProductList)
            uiState.test {
                Assert.assertTrue(awaitItem() is ProductListMvi.ProductListUiState.Error)
            }
        }
    }

//    @Test
//    fun `navigate to details screen when OnProductItemClick intent passed`() =
//        runTest {
//            with(viewModel) {
//                uiSideEffect.test {
//                    onSendIntent(ProductListMvi.ProductListUiIntent.OnProductItemClick(
//                        productDomainModel.id))
//                    Assert.assertTrue(awaitItem() is ProductListMvi.ProductListSideEffect.NavigateToDetailScreen)
//                }
//            }
//        }

}