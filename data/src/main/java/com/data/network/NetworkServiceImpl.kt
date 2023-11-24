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
        return if (response.isSuccessful){
            Result.success(response.body()?.map { item -> mapper  map  item } ?: listOf())
        }else{
            Result.failure(Throwable(response.message()))
        }
    }

    override fun fetchProductDetail(productId : Int) : Result<ProductDomainModel>{
        val response = apiService.getProductDetail(productId)
        return if (response.isSuccessful && response.body() != null){
            Result.success(mapper map response.body()!!)
        }else{
            Result.failure(Throwable(""))
        }
    }
}