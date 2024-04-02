package com.data.network

import android.util.Log
import com.data.api.ApiCall
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
    override suspend fun fetchProductList() : Result<List<ProductDomainModel>> {

        return ApiCall(
            apiCall = {apiService.getProducts()},
            mapper = { it.map { item -> item.toDomainModel() } },
            dispatcher = ioDispatcher
        )
    }

    override suspend fun fetchProductDetail(productId : Int) : Result<ProductDomainModel>{
        return ApiCall(
            apiCall = {apiService.getProductDetail(productId)},
            mapper = { it.toDomainModel() },
            dispatcher = ioDispatcher
        )
    }
}