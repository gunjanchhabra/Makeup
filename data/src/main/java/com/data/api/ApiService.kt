package com.data.api

import com.data.dto.ProductItemDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    companion object {
        private const val PRODUCT_API_ENDPOINT = "products.json"
        private const val PRODUCT_DETAIL_API_ENDPOINT = "products/{id}.json"
    }

    @GET(PRODUCT_API_ENDPOINT)
    suspend fun getProducts() : Response<List<ProductItemDto>>

    @GET(PRODUCT_DETAIL_API_ENDPOINT)
    fun getProductDetail(@Path("id") id: Int)
}