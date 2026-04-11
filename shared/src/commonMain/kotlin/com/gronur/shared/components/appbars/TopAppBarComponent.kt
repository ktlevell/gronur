package com.gronur.shared.components.appbars

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gronur.shared.theme.Black
import com.gronur.shared.theme.GronurTheme
import com.gronur.shared.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    modifier: Modifier = Modifier,
    title: @Composable (() -> Unit)? =  null,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable (RowScope.() -> Unit)? = null
) {
    TopAppBar(
       modifier = modifier
           .fillMaxWidth()
           .height(64.dp),
        title = {
            title?.invoke()
        },
        navigationIcon = {
            navigationIcon?.invoke()
        },
        actions = {
            actions?.invoke(this)
        },
        windowInsets =  WindowInsets(0,0,0,0),
        contentPadding = PaddingValues(16.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = White,
            titleContentColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = MaterialTheme.colorScheme.primary,
            actionIconContentColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
@Preview
fun TopAppBarComponentPreview() {
    GronurTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            TopAppBarComponent(
                modifier = Modifier
                    .fillMaxSize(),
                title = {
                    Text(
                        text = "Daily Grocery Food",
                        style = MaterialTheme.typography.headlineLarge,

                        maxLines = 2
                    )
                },
                actions = {
                    CircleSearchBar(
                        modifier = Modifier,
                        onClick = {}
                    )
                }
            )
        }
    }
}
