package com.products.presentation.mapper

import com.domain.model.ProductDomainModel
import com.products.presentation.model.ProductUiModel
import java.util.Locale
fun ProductDomainModel.toUiModel() = ProductUiModel(
    apiFeaturedImage = "${"https:"}${this.apiFeaturedImage}",
    brand = this.brand.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
    description = this.description,
    id = this.id,
    name = this.name,
    price = "${this.priceSign}${this.price}",
    priceSign = this.priceSign
)