package com.ktlevell.gronur.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gronur.shared.components.buttons.CategoryChip
import com.gronur.shared.components.cards.ItemCard
import com.gronur.shared.components.section.SectionHeader
import com.gronur.shared.theme.GronurTheme
import com.ktlevell.gronur.demo.Category
import com.ktlevell.gronur.demo.Product
import com.ktlevell.gronur.feature.components.GronurScaffold
import gronur.demo.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.decodeToImageBitmap

@Composable
fun HomeRoot(
    viewModel: HomeViewModel = viewModel { HomeViewModel() }
) {
    val state by viewModel.state.collectAsState()

    HomeScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun rememberLocalPainter(path: String?): Painter? {
    if (path == null) return null
    
    var painter by remember(path) { mutableStateOf<Painter?>(null) }
    
    LaunchedEffect(path) {
        try {
            val bytes = Res.readBytes("files/$path")
            val bitmap = bytes.decodeToImageBitmap()
            painter = BitmapPainter(bitmap)
        } catch (e: Exception) {
            println("Error loading image from files/$path: ${e.message}")
        }
    }
    
    return painter
}

@Composable
fun HomeScreen(
    state: HomeUiState,
    onAction: (HomeAction) -> Unit,
    modifier: Modifier = Modifier
) {
    GronurScaffold(
        modifier = modifier
            .fillMaxSize(),
        onSearchClicked = {
            onAction(
                HomeAction.OnSearchClicked
            )
        }
    ) { _ ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp,
                bottom = 16.dp
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
                    contentPadding = PaddingValues(start = 8.dp, end = 8.dp, bottom = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(
                        items = state.categories,
                        key = { it.id }
                    ) { category ->
                        CategoryChip(
                            modifier = Modifier,
                            category = category.name,
                            onClick = {
                                onAction(
                                    HomeAction.OnCategorySelected(category.id)
                                )
                            },
                            isSelected = category.isSelected
                        )
                    }
                }
            }

            item(
                span = {
                    GridItemSpan(maxLineSpan)
                }
            ) {
                SectionHeader(
                    title = state.selectedCategory?.let { "Popular ${it.name}" } ?: "",
                    onSeeAllClick = {}
                )
            }


            items(
                items = state.products,
                key = { it.id }
            ) { product ->
                ItemCard(
                    product = product,
                    painter = rememberLocalPainter(product.imageUrl),
                    onItemClick = {
                        onAction(
                            HomeAction.OnProductClicked(product.id)
                        )
                    },
                    onAddItemClick = {
                        onAction(
                            HomeAction.OnAddProductClicked(product.id, 1)
                        )
                    }
                )
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    GronurTheme {
        HomeScreen(
            state = HomeUiState(
                categories = listOf(
                    Category(id = 1, name = "Frutas", products = emptyList(), isSelected = true),
                    Category(id = 2, name = "Vegetais", products = emptyList())
                ),
                products = listOf(
                    Product(id = 1, name = "Maçã", price = 8.5, unit = "kg"),
                    Product(id = 2, name = "Banana", price = 5.9, unit = "kg")
                ),
                selectedCategory = Category(id = 1, name = "Frutas", products = emptyList(), isSelected = true)
            ),
            onAction = {}
        )
    }
}
