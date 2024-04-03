package com.data.network

import com.data.api.apiCall
import com.data.api.ApiService
import com.data.di.IODispatcher
import com.data.mapper.toDomainModel
import com.domain.model.ProductDomainModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class NetworkServiceImpl @Inject constructor(
    private val apiService: ApiService,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : NetworkService {
    override suspend fun fetchProductList() =
        apiCall(
            apiCall = { apiService.getProducts() },
            mapper = { it.map { item -> item.toDomainModel() } },
            dispatcher = ioDispatcher
        )

    override suspend fun fetchProductDetail(productId: Int) =
        apiCall(
            apiCall = { apiService.getProductDetail(productId) },
            mapper = { it.toDomainModel() },
            dispatcher = ioDispatcher
        )
}