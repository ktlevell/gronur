package com.ktlevell.gronur.feature.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import com.gronur.shared.components.appbars.NavBackBar
import com.gronur.shared.components.appbars.SearchAppBar
import com.gronur.shared.theme.GronurTheme
import com.gronur.shared.theme.White

@Composable
fun SearchRoot(
    onBackClicked: () -> Unit,
) {
    SearchScreen(
        onBackClicked = onBackClicked
    )
}

@Composable
fun SearchScreen(
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            NavBackBar(
                                modifier = Modifier,
                                onClick = onBackClicked
                            )

                            Text(
                                modifier = Modifier
                                    .weight(1f),
                                text = "Search",
                                style = MaterialTheme.typography.titleLarge,
                                textAlign = TextAlign.Center
                            )
                        }

                        Spacer(Modifier.height(24.dp))

                        SearchAppBar(
                            query = "",
                            onQueryChange = {},
                            onFilterClick = {}
                        )

                        Spacer(Modifier.height(16.dp))
                    }
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = White
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding()),
            color = White,
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
        ) {

        }

    }
}

@Composable
@Preview
fun SearchScreenPreview() {
    GronurTheme {
        SearchScreen(
            onBackClicked = {}
        )
    }
}