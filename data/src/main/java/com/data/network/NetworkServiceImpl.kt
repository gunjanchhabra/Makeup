package com.data.network

import android.util.Log
import com.data.api.ApiService
import com.data.mapper.ProductDtoToDomainMapper
import com.domain.model.ProductDomainModel
import javax.inject.Inject

class NetworkServiceImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: ProductDtoToDomainMapper
) : NetworkService {
    override suspend fun fetchProductList() : Result<List<ProductDomainModel>> {
        val response = apiService.getProducts()
        if (response.isSuccessful){
            Log.d("Gunjan service", response.body().toString())
            return Result.success(response.body()?.map { item -> mapper  map  item } ?: listOf())
        }else{
           return Result.failure(Throwable(response.message()))
        }
    }

    override fun fetchProductDetail() {
        apiService.getProductDetail(1)
    }
}