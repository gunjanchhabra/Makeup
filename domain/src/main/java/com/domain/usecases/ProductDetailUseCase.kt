package com.domain.usecases

import com.domain.model.ProductDomainModel

interface ProductDetailUseCase {
    operator fun invoke(productId : Int) : Result<ProductDomainModel>
}