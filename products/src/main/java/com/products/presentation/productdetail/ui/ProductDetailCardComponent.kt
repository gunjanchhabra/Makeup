package com.products.presentation.productdetail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.products.R
import com.products.presentation.base.ui.CustomImage
import com.products.presentation.base.ui.CustomText
import com.products.presentation.model.ProductUiModel

@Composable
fun ProductDetailCardComponent(product: ProductUiModel) {

    Column(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        CustomImage(
            data = product.apiFeaturedImage,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        CustomText(
            text = "${product.brand} ${product.name}",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            color = Color.Black,
            maxLines = 1
        )
        CustomText(
            text = product.price,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            color = Color.Gray
        )

        CustomText(
            text = stringResource(R.string.description),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, start = 10.dp, end = 10.dp),
            color = Color.Black
        )

        CustomText(
            text = product.description,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            color = Color.Black
        )
    }
}