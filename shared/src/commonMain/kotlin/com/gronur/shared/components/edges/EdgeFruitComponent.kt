package com.gronur.shared.components.edges

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gronur.shared.theme.GronurTheme
import gronur.shared.generated.resources.Res
import gronur.shared.generated.resources.ic_strawberry
import org.jetbrains.compose.resources.painterResource

@Composable
fun EdgeFruits(
    imageResource: Painter,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(500.dp),
        shape = RoundedCornerShape(40.dp),
        color = MaterialTheme.colorScheme.background,
        shadowElevation = 8.dp,
        tonalElevation = 0.dp
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = imageResource,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}

@Composable
@Preview
fun EdgeFruitsPreview() {
    GronurTheme {
        EdgeFruits(
            imageResource = painterResource(Res.drawable.ic_strawberry),
        )
    }
}