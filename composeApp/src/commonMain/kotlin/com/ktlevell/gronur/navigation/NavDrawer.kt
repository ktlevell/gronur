package com.ktlevell.gronur.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gronur.shared.theme.BG1
import com.gronur.shared.theme.White
import kotlinx.coroutines.launch

@Composable
fun NavDrawer(
    drawerState: DrawerState,
    currentDestination: Destination,
    onDestinationClicked: (Destination) -> Unit,
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = currentDestination.isRoot,
        drawerContent = {
            if (currentDestination.isRoot) {

                Destination.rootDestinations.forEach { destination ->
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = destination.title ?: ""
                            )
                        },
                        icon = {
                            Icon(
                                painter = Destination.getIcon(destination),
                                contentDescription = null
                            )
                        },
                        selected = currentDestination::class == destination::class,
                        onClick = {
                            scope.launch { drawerState.close() }
                            onDestinationClicked(destination)
                        },
                        modifier = Modifier.padding(horizontal = 12.dp),
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedIconColor = White,
                            unselectedIconColor = BG1,
                            selectedTextColor = White,
                            unselectedTextColor = BG1,
                            selectedContainerColor = Color.Transparent,
                            unselectedContainerColor = Color.Transparent,
                            selectedBadgeColor = Color.Transparent,
                            unselectedBadgeColor = Color.Transparent
                        )
                    )
                }
            }
        },
        content = content
    )
    
}

