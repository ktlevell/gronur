package com.gronur.shared.components.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gronur.shared.theme.BG1
import com.gronur.shared.theme.GronurTheme

@Composable
fun SectionHeader(
    title: String,
    onSeeAllClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.SemiBold,
                lineHeight = 38.sp,
                letterSpacing = 0.5.sp
            ),
        )

        TextButton(
            onClick = onSeeAllClick,
        ) {
            Text(
                text = "See all",
                style = MaterialTheme.typography.bodySmall,
                color = BG1
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SectionHeaderPreview() {
    GronurTheme {
        SectionHeader(
            title = "Popular Fruits",
            onSeeAllClick = {}
        )
    }
}