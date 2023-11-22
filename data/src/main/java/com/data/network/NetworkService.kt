package com.data.network

import com.domain.model.ProductDomainModel

interface NetworkService {

    suspend fun fetchProductList() : Result<List<ProductDomainModel>>
    fun fetchProductDetail()
}