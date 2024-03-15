package com.data.repository

import com.data.network.NetworkService
import com.domain.model.ProductDomainModel
import com.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val networkService: NetworkService
) : ProductRepository {
    override suspend fun fetchProductList() : Result<List<ProductDomainModel>>{
       return networkService.fetchProductList()
    }

    override suspend fun fetchProductDetail(productId: Int) : Result<ProductDomainModel>{
        return networkService.fetchProductDetail(productId)
    }
}