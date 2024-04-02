package com.products.mapper

import com.products.TestData.productDomainModel
import com.products.TestData.productUiModel
import com.products.presentation.mapper.toUiModel
import org.junit.Assert
import org.junit.Test

class ProductListUiMapper {
    @Test
    fun `toUiModel should convert ProductDomainModel to ProductUiModel correctly`() {
        val result = productDomainModel.toUiModel()
        Assert.assertEquals(result.name, productUiModel.name)

    }
}