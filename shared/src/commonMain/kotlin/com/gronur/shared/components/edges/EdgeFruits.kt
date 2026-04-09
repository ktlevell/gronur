package com.gronur.shared.components.edges

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gronur.shared.theme.GronurTheme
import gronur.shared.generated.resources.Res
import gronur.shared.generated.resources.ic_fruits
import org.jetbrains.compose.resources.painterResource

@Composable
fun EdgeFruits(
    imageResource: Painter,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .width(500.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = imageResource,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
@Preview
fun EdgeFruitsPreview() {
    GronurTheme {
        EdgeFruits(
            imageResource = painterResource(Res.drawable.ic_fruits),
        )
    }
}