package com.gronur.shared.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gronur.shared.theme.GronurIcons
import com.gronur.shared.theme.GronurTheme
import com.gronur.shared.theme.White

@Composable
fun CircleButton(
    onClick: () -> Unit,
    iconRes: Painter,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .clickable { onClick() }
        ,
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = iconRes,
            contentDescription = "",
            tint = White
        )
    }
}

@Composable
@Preview
fun CircleButtonPlusPreview() {
    GronurTheme {
        CircleButton(
            onClick = {},
            iconRes = GronurIcons.plus(),
        )
    }
}

@Composable
@Preview
fun CircleButtonMinusPreview() {
    GronurTheme {
        CircleButton(
            onClick = {},
            iconRes = GronurIcons.minus(),
        )
    }
}