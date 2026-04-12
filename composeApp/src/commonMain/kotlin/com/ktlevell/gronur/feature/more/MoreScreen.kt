package com.ktlevell.gronur.feature.more

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gronur.shared.theme.GronurTheme
import com.ktlevell.gronur.feature.components.GronurScaffold

@Composable
fun MoreRoot(

) {
    MoreScreen()
}

@Composable
fun MoreScreen(
    modifier: Modifier = Modifier
) {
    GronurScaffold(
        modifier = modifier
            .fillMaxSize(),
        showCircleSearch = false,
        onSearchClicked = {}
    ) { _ ->

    }
}

@Composable
@Preview
fun MoreScreenPreview() {
    GronurTheme {
        MoreScreen()
    }
}