package com.ktlevell.gronur.feature.cart

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
import com.gronur.shared.components.appbars.CircleSearchBar
import com.gronur.shared.components.appbars.GronurTopAppBar
import com.gronur.shared.components.buttons.CategoryChip
import com.gronur.shared.theme.GronurTheme
import com.ktlevell.gronur.feature.components.GronurScaffold
import gronur.composeapp.generated.resources.Res
import gronur.composeapp.generated.resources.feat_title_grocery
import org.jetbrains.compose.resources.stringResource

@Composable
fun CartRoot(

) {
    CartScreen()
}

@Composable
fun CartScreen(
    modifier: Modifier = Modifier
) {
    GronurScaffold(
        modifier = Modifier
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

        }
    }
}

@Composable
@Preview
fun CartScreenPreview() {
    GronurTheme {
        CartScreen()

    }
}