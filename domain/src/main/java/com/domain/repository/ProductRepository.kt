package com.domain.repository

import com.domain.model.ProductDomainModel

interface ProductRepository {
    suspend fun fetchProductList() : Result<List<ProductDomainModel>>
    suspend fun fetchProductDetail(productId: Int) : Result<ProductDomainModel>
}