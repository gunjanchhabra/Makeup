package com.data.repository

import com.data.TestData.productDomainModel
import com.data.TestData.productItemDto
import com.data.network.NetworkService
import com.domain.repository.ProductRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class ProductRepositoryImplTest{

    private val networkService = mockk<NetworkService>()

    private lateinit var productRepository: ProductRepository
    @Before
    fun setup() {
        productRepository = ProductRepositoryImpl(networkService = networkService)
    }

    @Test
    fun `fetchProductList() returns success Result`() = runTest {
        coEvery { networkService.fetchProductList() } returns Result.success(mutableListOf(
            productDomainModel))
        val result = productRepository.fetchProductList()

        result.onSuccess {
            assertEquals(it[0].name, productDomainModel.name)
        }
    }

    @Test
    fun `getTvShowDetails() returns success Result of TvShowDetailsModel`() = runTest {
        coEvery {
            networkService.fetchProductDetail(100)
        } returns Result.success(productDomainModel)
        val result = productRepository.fetchProductDetail(100)

        result.onSuccess {
            assertEquals(it.name, productDomainModel.name)
        }
    }
}