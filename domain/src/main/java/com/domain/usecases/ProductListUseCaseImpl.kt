package com.domain.usecases

import com.domain.repository.ProductRepository
import javax.inject.Inject

class ProductListUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : ProductListUseCase{
    override suspend fun invoke() = productRepository.fetchProductList()
}