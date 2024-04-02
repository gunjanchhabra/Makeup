package com.data

import com.data.dto.ProductItemDto
import com.domain.model.ProductDomainModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

object TestData {
    val errorResponse: Response<ProductItemDto> = Response.error(
        404, "".toResponseBody("application/json".toMediaTypeOrNull())
    )
    val productItemDto = ProductItemDto(
        apiFeaturedImage = "//s3.amazonaws.com/donovanbailey/products/api_featured_images/000/001/044/original/data?1531071233",
        brand = "ColorBar",
        category = "Lipstick",
        createdAt = "2018-07-08T17:32:28.088Z",
        currency = "CAD",
        description = "All of our products are free from lead and heavy metals, parabens, phthalates, artificial colourants, and synthetic fragrances.  Boosh lipstick glides on smoothly for clean \\u0026 protective SPF coverage. They are filled with hydrating oils and butters to preserve and enhance your lips natural surface. Organic sweet orange oil gives a light and cheerful scent.",
        id = 1044,
        imageLink = "https://cdn.shopify.com/s/files/1/1016/3243/products/LIPBALM_LID_grande.jpg?v=1496848378",
        name = "Lipstick",
        price = "26.0",
        priceSign = "$",
        productApiUrl = "https://makeup-api.herokuapp.com/api/v1/products/1044.json",
        productColors = emptyList(),
        productLink = "https://www.boosh.ca/collections/all",
        productType = "lipstick",
        rating = 0.0,
        tagList = emptyList(),
        updatedAt = "2018-09-02T22:52:06.669Z",
        websiteLink = "https://www.boosh.ca/"
    )


    val productDomainModel = ProductDomainModel(
        apiFeaturedImage = "//s3.amazonaws.com/donovanbailey/products/api_featured_images/000/001/044/original/data?1531071233",
        brand = "ColorBar",
        description = "All of our products are free from lead and heavy metals, parabens, phthalates, artificial colourants, and synthetic fragrances.  Boosh lipstick glides on smoothly for clean \\u0026 protective SPF coverage. They are filled with hydrating oils and butters to preserve and enhance your lips natural surface. Organic sweet orange oil gives a light and cheerful scent.",
        id = 1044,
        name = "Lipstick",
        price = "26.0",
        priceSign = "$"
    )

}