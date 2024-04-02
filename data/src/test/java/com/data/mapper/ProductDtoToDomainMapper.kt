package com.data.mapper

import com.data.TestData.productDomainModel
import com.data.TestData.productItemDto
import com.data.dto.ProductItemDto
import com.domain.model.ProductDomainModel
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductDtoToDomainMapper {
    @Test
    fun `toDomainModel should convert ProductItemDto to ProductDomainModel correctly`() {
        val result = productItemDto.toDomainModel()
        assertEquals(result.name, productDomainModel.name)
    }

}