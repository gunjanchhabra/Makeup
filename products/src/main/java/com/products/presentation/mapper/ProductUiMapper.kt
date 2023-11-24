package com.products.presentation.mapper

import com.domain.model.ProductDomainColor
import com.domain.model.ProductDomainModel
import com.products.presentation.model.ProductUiColor
import com.products.presentation.model.ProductUiModel
import javax.inject.Inject

class ProductUiMapper @Inject constructor() {
    infix fun map(domainModel: ProductDomainModel): ProductUiModel {
        return ProductUiModel(
            apiFeaturedImage = domainModel.apiFeaturedImage,
            brand = domainModel.brand,
            category = domainModel.category,
            createdAt = domainModel.createdAt,
            currency = domainModel.currency,
            description = domainModel.description,
            id = domainModel.id,
            imageLink = domainModel.imageLink,
            name = domainModel.name,
            price = domainModel.price,
            priceSign = domainModel.priceSign,
            productApiUrl = domainModel.productApiUrl,
            productColors = domainModel.productColors.map { this.mapColor(it) },
            productLink = domainModel.productLink,
            productType = domainModel.productType,
            rating = domainModel.rating,
            tagList = domainModel.tagList,
            updatedAt = domainModel.updatedAt,
            websiteLink = domainModel.websiteLink
        )
    }

    private fun mapColor(productColor: ProductDomainColor): ProductUiColor {
        return ProductUiColor(
            colourName = productColor.colourName,
            hexValue = productColor.hexValue
        )
    }
}