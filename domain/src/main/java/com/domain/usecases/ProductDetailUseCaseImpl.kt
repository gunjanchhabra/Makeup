package com.domain.usecases

import com.domain.repository.ProductRepository
import javax.inject.Inject

class ProductDetailUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : ProductDetailUseCase{
    override fun invoke() {
        productRepository.fetchProductDetail()
    }
}