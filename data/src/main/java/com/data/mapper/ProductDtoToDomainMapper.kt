package com.data.mapper

import com.data.dto.ProductColor
import com.data.dto.ProductItemDto
import com.domain.model.ProductDomainColor
import com.domain.model.ProductDomainModel
import javax.inject.Inject

class ProductDtoToDomainMapper @Inject constructor() {
    infix fun map(productItemDto: ProductItemDto): ProductDomainModel {
        return ProductDomainModel(
            apiFeaturedImage = productItemDto.apiFeaturedImage,
            brand = productItemDto.brand,
            category = productItemDto.category,
            createdAt = productItemDto.createdAt,
            currency = productItemDto.currency,
            description = productItemDto.description,
            id = productItemDto.id,
            imageLink = productItemDto.imageLink,
            name = productItemDto.name,
            price = productItemDto.price,
            priceSign = productItemDto.priceSign,
            productApiUrl = productItemDto.productApiUrl,
            productColors = productItemDto.productColors.map { this.mapColor(it) },
            productLink = productItemDto.productLink,
            productType = productItemDto.productType,
            rating = productItemDto.rating,
            tagList = productItemDto.tagList,
            updatedAt = productItemDto.updatedAt,
            websiteLink = productItemDto.websiteLink
        )
    }

    private fun mapColor(productColor: ProductColor): ProductDomainColor {
        return ProductDomainColor(
            colourName = productColor.colourName,
            hexValue = productColor.hexValue
        )
    }
}