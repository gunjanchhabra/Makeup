package com.domain.usecase

import com.domain.TestData
import com.domain.TestData.productDomainModel
import com.domain.repository.ProductRepository
import com.domain.usecases.ProductDetailUseCase
import com.domain.usecases.ProductDetailUseCaseImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ProductDetailUseCaseTest {

    private val productRepository= mockk<ProductRepository>()
    private lateinit var productDetailUseCase: ProductDetailUseCase

    @Before
    fun setup(){
        productDetailUseCase = ProductDetailUseCaseImpl(productRepository)
    }

    @Test
    fun `fetchProductList returns Result of ProductDomainModel`()= runTest{
        coEvery { productRepository.fetchProductDetail(1044) } returns Result.success(productDomainModel)
        productDetailUseCase(1044).onSuccess {
            Assert.assertEquals(it.name, productDomainModel.name)
        }
    }
}