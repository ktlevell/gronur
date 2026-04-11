package com.gronur.shared.components.buttons

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gronur.shared.theme.GronurIcons
import com.gronur.shared.theme.GronurTheme

@Composable
fun CircleAddItem(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier
            .size(24.dp),
        onClick = onClick,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary
        ),
        shape = RoundedCornerShape(5.dp)
    ) {
        Icon(
            modifier = Modifier
                .size(18.dp),
            painter = GronurIcons.plus(),
            contentDescription = "Add Item"
        )
    }
}

@Composable
@Preview
fun CircleAddItemPreview() {
    GronurTheme {
        CircleAddItem(
            onClick = {}
        )
    }
}