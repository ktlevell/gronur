package com.gronur.shared.components.appbars

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gronur.shared.theme.Black
import com.gronur.shared.theme.GronurIcons
import com.gronur.shared.theme.GronurTheme

@Composable
fun SearchAppBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onFilterClick: () -> Unit,
    placeholder: String = "Search",
    modifier: Modifier = Modifier
) {
    var isSearchPressed by remember { mutableStateOf(false) }
    var isFilterPressed by remember { mutableStateOf(false) }

    val searchScale by animateFloatAsState(
        targetValue = if (isSearchPressed) 0.9f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
        label = "searchScale"
    )

    val filterScale by animateFloatAsState(
        targetValue = if (isFilterPressed) 0.9f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
        label = "filterScale"
    )

    val surfaceColor = MaterialTheme.colorScheme.surface
    val contentColor = Black

    Surface(
        color = surfaceColor,
        shape = CircleShape,
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .clip(CircleShape)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = GronurIcons.search(),
                contentDescription = "Search",
                tint = contentColor,
                modifier = Modifier
                    .graphicsLayer(scaleX = searchScale, scaleY = searchScale)
                    .size(24.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = {}
                    )
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                isSearchPressed = true
                                try { awaitRelease() } finally { isSearchPressed = false }
                            }
                        )
                    }
            )

            Spacer(modifier = Modifier.width(16.dp))

            BasicTextField(
                value = query,
                onValueChange = onQueryChange,
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyLarge
                    .copy(color = MaterialTheme.colorScheme.onSurface),
                modifier = Modifier
                    .weight(1f),
                decorationBox = { innerTextField ->
                    if (query.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = MaterialTheme.typography.bodyLarge,
                            color = contentColor
                        )
                    }
                    innerTextField()
                }
            )

            Spacer(modifier = Modifier.width(16.dp))

            Icon(
                painter = GronurIcons.sliderHorizontal(),
                contentDescription = "Filter",
                tint = contentColor,
                modifier = Modifier
                    .graphicsLayer(scaleX = filterScale, scaleY = filterScale)
                    .size(28.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = onFilterClick
                    )
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                isFilterPressed = true
                                try { awaitRelease() } finally { isFilterPressed = false }
                            }
                        )
                    }
            )
        }
    }
}

@Composable
@Preview
fun SearchAppBarPreview() {
    GronurTheme {
        SearchAppBar(
            query = "Fresh Melon",
            onQueryChange = {},
            onFilterClick = {}
        )
    }
}