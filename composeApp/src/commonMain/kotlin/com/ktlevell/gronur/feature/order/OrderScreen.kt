package com.ktlevell.gronur.feature.order

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gronur.shared.components.buttons.CategoryChip
import com.gronur.shared.theme.GronurTheme
import com.ktlevell.gronur.feature.components.GronurScaffold

@Composable
fun OrderRoot(

) {
    OrderScreen()
}

@Composable
fun OrderScreen(
    modifier: Modifier = Modifier
) {
    GronurScaffold(
        modifier = modifier
            .fillMaxSize(),
        onSearchClicked = {}
    ) { _ ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(
                horizontal = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item(
                span = {
                    GridItemSpan(maxLineSpan)
                }
            ) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(5) {
                        CategoryChip(
                            modifier = Modifier,
                            category = "All Order",
                            onClick = {},
                            isSelected = it == 0
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun OrderScreenPreview() {
    GronurTheme {
        OrderScreen()
    }
}