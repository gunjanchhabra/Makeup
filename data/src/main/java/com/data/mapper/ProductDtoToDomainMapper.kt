package com.data.mapper

import com.data.dto.ProductColor
import com.data.dto.ProductItemDto
import com.domain.model.ProductDomainColor
import com.domain.model.ProductDomainModel
import javax.inject.Inject

fun ProductItemDto.toDomainModel() = ProductDomainModel(
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
    productColors = this.productColors.map { it.toDomainModel() },
    productLink = this.productLink,
    productType = this.productType,
    rating = this.rating,
    tagList = this.tagList,
    updatedAt = this.updatedAt,
    websiteLink = this.websiteLink
)

fun ProductColor.toDomainModel() = ProductDomainColor(
    colourName = this.colourName,
    hexValue = this.hexValue
)