package com.gronur.shared.components.appbars

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gronur.shared.theme.BG1
import com.gronur.shared.theme.BG2
import com.gronur.shared.theme.GronurIcons
import com.gronur.shared.theme.GronurTheme

@Composable
fun NavBackBar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .border(
                width = 2.dp,
                color = BG1,
                shape = CircleShape
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = GronurIcons.arrowBack(),
            contentDescription = "Back",
            modifier = Modifier
                .size(24.dp),
            tint = BG2
        )
    }
}

@Composable
@Preview
fun NavBackBarPreview() {
    GronurTheme {
        NavBackBar(
            onClick = {}
        )
    }
}