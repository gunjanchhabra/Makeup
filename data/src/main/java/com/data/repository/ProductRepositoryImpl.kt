package com.data.repository

import com.data.network.NetworkService
import com.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val networkService: NetworkService
) : ProductRepository {
    override suspend fun fetchProductList()  = networkService.fetchProductList()

    override suspend fun fetchProductDetail(productId: Int) = networkService.fetchProductDetail(productId)

}