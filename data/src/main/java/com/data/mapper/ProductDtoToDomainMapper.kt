package com.data.mapper

import com.data.dto.ProductItemDto
import com.domain.model.ProductDomainModel

fun ProductItemDto.toDomainModel() = ProductDomainModel(
    apiFeaturedImage = this.apiFeaturedImage,
    brand = this.brand,
    description = this.description,
    id = this.id,
    name = this.name,
    price = this.price,
    priceSign = this.priceSign
)