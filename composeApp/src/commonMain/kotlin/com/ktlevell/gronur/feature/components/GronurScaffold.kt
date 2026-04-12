package com.ktlevell.gronur.feature.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gronur.shared.components.appbars.CircleSearchBar
import com.gronur.shared.components.appbars.GronurTopAppBar
import com.ktlevell.gronur.navigation.GronurBottomAppBar
import com.ktlevell.gronur.navigation.LocalCurrentDestination
import com.ktlevell.gronur.navigation.LocalOnDestinationClicked
import gronur.composeapp.generated.resources.Res
import gronur.composeapp.generated.resources.feat_title_grocery
import org.jetbrains.compose.resources.stringResource

@Composable
fun GronurScaffold(
    onSearchClicked: () -> Unit,
    modifier: Modifier = Modifier,
    showCircleSearch: Boolean = true,
    floatingActionButton: @Composable () -> Unit = {},
    containerColor: Color = MaterialTheme.colorScheme.primary,
    content: @Composable (PaddingValues) -> Unit
) {
    val currentDestination = LocalCurrentDestination.current
    val onDestinationClicked = LocalOnDestinationClicked.current

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            GronurTopAppBar(
                modifier = Modifier,
                title = stringResource(Res.string.feat_title_grocery),
                search = {
                    if (showCircleSearch) {
                        CircleSearchBar(
                            modifier = Modifier,
                            onClick = onSearchClicked
                        )
                    }
                }
            )
        },
        bottomBar = {
            GronurBottomAppBar(
                currentDestination = currentDestination,
                onDestinationClicked = onDestinationClicked
            )
        },
        floatingActionButton = floatingActionButton,
        containerColor = containerColor,
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = Color.White,
            shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                content(PaddingValues(0.dp))
            }
        }
    }
}
