package com.products.presentation.model

data class ProductUiModel(
    val apiFeaturedImage: String,
    val brand: String,
    val category: String,
    val createdAt: String,
    val currency: String,
    val description: String,
    val id: Int,
    val imageLink: String,
    val name: String,
    val price: String,
    val priceSign: String,
    val productApiUrl: String,
    val productColors: List<ProductUiColor>,
    val productLink: String,
    val productType: String,
    val rating: Double,
    val tagList: List<String>,
    val updatedAt: String,
    val websiteLink: String
)

data class ProductUiColor(
    val colourName: String,
    val hexValue: String
)