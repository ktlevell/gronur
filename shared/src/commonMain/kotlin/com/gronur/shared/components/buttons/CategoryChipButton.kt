package com.gronur.shared.components.buttons

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gronur.shared.theme.Black
import com.gronur.shared.theme.GronurTheme
import com.gronur.shared.theme.White

@Composable
fun CategoryChip(
    category: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.surface,
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing),
        label = "backgroundColor"
    )

    val contentColor by animateColorAsState(
        targetValue = if (isSelected) White else Black,
        animationSpec = tween(durationMillis = 300, easing = LinearEasing),
        label = "textColor"
    )


    Box(
        modifier = modifier
            .width(120.dp)
            .height(46.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(color = backgroundColor,)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = category,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1,
            color = contentColor,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
        )
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun CategoryChipPreview() {
    GronurTheme {
        val categories = listOf("Fruits", "Fast-food", "Vegetables")
        var selectedCategory by remember { mutableStateOf("Fruits") }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            categories.forEach { category ->
                CategoryChip(
                    category = category,
                    isSelected = selectedCategory == category,
                    onClick = { selectedCategory = category }
                )
            }
        }
    }
}