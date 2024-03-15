package com.domain.usecases

import com.domain.model.ProductDomainModel
import com.domain.repository.ProductRepository
import javax.inject.Inject

class ProductDetailUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : ProductDetailUseCase{
    override suspend fun invoke(productId : Int) : Result<ProductDomainModel>{
       return productRepository.fetchProductDetail(productId)
    }
}