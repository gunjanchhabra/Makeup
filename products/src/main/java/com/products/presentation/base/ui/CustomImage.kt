package com.products.presentation.base.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
@Composable
fun CustomImage(
    modifier: Modifier = Modifier,
    data: Any?,
    contentDescription: String? = null,
    contentScale: ContentScale
) {
    Image(
        painter = rememberAsyncImagePainter(data),
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
    )
}
