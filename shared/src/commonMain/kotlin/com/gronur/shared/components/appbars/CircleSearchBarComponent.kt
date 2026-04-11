package com.gronur.shared.components.appbars

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gronur.shared.theme.BG2
import com.gronur.shared.theme.GronurIcons
import com.gronur.shared.theme.GronurTheme

@Composable
fun CircleSearchBar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .width(64.dp)
            .height(90.dp)
            .clip(CircleShape)
            .background(Color.White)
            .border(
                width = 2.dp,
                color = BG2,
                shape = CircleShape
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = GronurIcons.search(),
            contentDescription = "Search",
            modifier = Modifier.size(36.dp),
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
@Preview
fun CircleSearchBarPreview() {
    GronurTheme {
        CircleSearchBar(
            onClick = {}
        )
    }
}