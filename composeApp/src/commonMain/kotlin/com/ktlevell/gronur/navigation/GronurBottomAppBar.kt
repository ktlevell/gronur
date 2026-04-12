package com.ktlevell.gronur.navigation

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gronur.shared.theme.BG1
import com.gronur.shared.theme.GronurTheme
import com.gronur.shared.theme.Primary0100
import com.gronur.shared.theme.White

@Composable
fun GronurBottomAppBar(
    currentDestination: Destination,
    onDestinationClicked: (Destination) -> Unit,
    modifier: Modifier = Modifier
) {
    if (currentDestination.isRoot) {
        NavigationBar(
            modifier = modifier.navigationBarsPadding(),
            containerColor = Primary0100,
            contentColor = BG1,
            tonalElevation = 0.dp
        ) {
            Destination.rootDestinations.forEach { destination ->
                val selected = currentDestination == destination
                NavigationBarItem(
                    selected = selected,
                    onClick = { onDestinationClicked(destination) },
                    icon = {
                        Destination.getIcon(destination)?.let {
                            Icon(
                                painter = it,
                                contentDescription = destination.title
                            )
                        }
                    },
                    label = {
                        destination.title?.let {
                            Text(text = it)
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = White,
                        selectedTextColor = White,
                        unselectedIconColor = BG1,
                        unselectedTextColor = BG1,
                        indicatorColor = Color.Transparent,
                    )
                )
            }
        }
    }

}

@Composable
@Preview
fun GronurBottomAppBarPreview() {
    GronurTheme {
        GronurBottomAppBar(
            currentDestination = Destination.Home,
            onDestinationClicked = {}
        )
    }
}
