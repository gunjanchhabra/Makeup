package com.domain.usecase

import com.domain.TestData.productDomainModel
import com.domain.repository.ProductRepository
import com.domain.usecases.ProductListUseCase
import com.domain.usecases.ProductListUseCaseImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ProductListUseCaseTest {

    private val productRepository= mockk<ProductRepository>()
    private lateinit var productListUseCase: ProductListUseCase

    @Before
    fun setup(){
        productListUseCase = ProductListUseCaseImpl(productRepository)
    }

    @Test
    fun `fetchProductList returns Result of ProductDomainModel`()= runTest{
        coEvery { productRepository.fetchProductList() } returns Result.success(mutableListOf(productDomainModel))
        productListUseCase().onSuccess {
            assertEquals(it[0].name, mutableListOf(productDomainModel)[0].name)
        }
    }
}