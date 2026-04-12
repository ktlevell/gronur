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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gronur.shared.components.buttons.CategoryChip
import com.gronur.shared.components.cards.ItemCard
import com.gronur.shared.components.section.SectionHeader
import com.gronur.shared.remember.rememberLocalPainter
import com.gronur.shared.theme.GronurTheme
import com.ktlevell.gronur.demo.Category
import com.ktlevell.gronur.demo.Product
import com.ktlevell.gronur.feature.components.GronurScaffold

@Composable
fun HomeRoot(
    onProductClicked: (Int) -> Unit,
    onSearchClick: () -> Unit,
    onSeeAllClick: () -> Unit,
    viewModel: HomeViewModel = viewModel { HomeViewModel() }
) {
    val state by viewModel.state.collectAsState()

    HomeScreen(
        state = state,
        onAction = viewModel::onAction,
        onSearchClicked = onSearchClick,
        onSeeAllClicked = onSeeAllClick,
        onProductClicked = onProductClicked
    )
}

@Composable
fun HomeScreen(
    state: HomeUiState,
    onAction: (HomeAction) -> Unit,
    modifier: Modifier = Modifier,
    onSearchClicked: () -> Unit,
    onSeeAllClicked: () -> Unit,
    onProductClicked: (Int) -> Unit
) {
    GronurScaffold(
        modifier = modifier
            .fillMaxSize(),
        onSearchClicked = onSearchClicked
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
                state.selectedCategory?.let { category ->
                    SectionHeader(
                        title = category.name,
                        onSeeAllClick = onSeeAllClicked
                    )
                }
            }

            items(
                items = state.products,
                key = { it.id }
            ) { product ->
                ItemCard(
                    product = product,
                    painter = rememberLocalPainter(product.imageUrl),
                    onItemClick = {
                        onProductClicked(product.id)
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
            onAction = {},
            onSearchClicked = {},
            onSeeAllClicked = {},
            onProductClicked = {}
        )
    }
}
