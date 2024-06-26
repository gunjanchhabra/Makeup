package com.products.presentation.base.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
@Composable
fun CustomText(
    text: String,
    style: TextStyle,
    modifier: Modifier,
    color: Color=Color.Black,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        style = style,
        modifier = modifier,
        color = color,
        maxLines = maxLines
    )
}