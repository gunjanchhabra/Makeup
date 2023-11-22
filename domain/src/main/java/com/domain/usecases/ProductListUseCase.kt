package com.domain.usecases

import com.domain.model.ProductDomainModel

interface ProductListUseCase {
    suspend operator fun invoke() : Result<List<ProductDomainModel>>
}