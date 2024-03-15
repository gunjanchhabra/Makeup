package com.products.presentation.mapper

import com.domain.model.ProductDomainColor
import com.domain.model.ProductDomainModel
import com.products.presentation.model.ProductUiColor
import com.products.presentation.model.ProductUiModel
import javax.inject.Inject

fun ProductDomainModel.toUiModel() = ProductUiModel(
    apiFeaturedImage = this.apiFeaturedImage,
    brand = this.brand,
    category = this.category,
    createdAt = this.createdAt,
    currency = this.currency,
    description = this.description,
    id = this.id,
    imageLink = this.imageLink,
    name = this.name,
    price = this.price,
    priceSign = this.priceSign,
    productApiUrl = this.productApiUrl,
    productColors = this.productColors.map { it.toUiModel() },
    productLink = this.productLink,
    productType = this.productType,
    rating = this.rating,
    tagList = this.tagList,
    updatedAt = this.updatedAt,
    websiteLink = this.websiteLink
)

fun ProductDomainColor.toUiModel() = ProductUiColor(
    colourName = this.colourName,
    hexValue = this.hexValue
)