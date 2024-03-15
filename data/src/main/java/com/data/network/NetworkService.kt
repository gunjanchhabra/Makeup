package com.data.network

import com.domain.model.ProductDomainModel

interface NetworkService {
    suspend fun fetchProductList() : Result<List<ProductDomainModel>>
    suspend fun fetchProductDetail(productId : Int) : Result<ProductDomainModel>
}