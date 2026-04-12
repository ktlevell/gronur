package com.ktlevell.gronur.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.toRoute
import com.gronur.shared.theme.GronurTheme
import com.ktlevell.gronur.feature.cart.CartRoot
import com.ktlevell.gronur.feature.details.DetailsRoot
import com.ktlevell.gronur.feature.home.HomeRoot
import com.ktlevell.gronur.feature.more.MoreRoot
import com.ktlevell.gronur.feature.order.OrderRoot
import com.ktlevell.gronur.feature.products.ProductsRoot
import com.ktlevell.gronur.feature.search.SearchRoot


@Composable
fun NavigationHost(
    navController: NavHostController,
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed)
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestinationInGraph = navBackStackEntry?.destination
    
    val currentDestination = Destination.rootDestinations.find { root ->
        currentDestinationInGraph?.hasRoute(root::class) == true
    } ?: Destination.Home

    val onNavigateToRoot: (Destination) -> Unit = { destination ->
        navController.navigate(destination) {
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    GronurTheme {
        CompositionLocalProvider(
            LocalCurrentDestination provides currentDestination,
            LocalOnDestinationClicked provides onNavigateToRoot
        ) {
            NavDrawer(
                drawerState = drawerState,
                currentDestination = currentDestination,
                onDestinationClicked = onNavigateToRoot
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Destination.Home,
                ) {
                    composable<Destination.Home> {
                        HomeRoot(
                            onSearchClick = {
                                navController.navigate(Destination.Search)
                            },
                            onSeeAllClick = {
                                navController.navigate(Destination.Products)
                            },
                            onProductClicked = { id ->
                                navController.navigate(Destination.Details(id = id))
                            }
                        )
                    }

                    composable<Destination.Order> {
                        OrderRoot()
                    }

                    composable<Destination.Cart> {
                        CartRoot()
                    }

                    composable<Destination.More> {
                        MoreRoot()
                    }

                    composable<Destination.Details> { backStackEntry ->
                        DetailsRoot(
                            id = 1,
                            onBackClicked = {
                                navController.popBackStack()
                            }
                        )
                    }

                    composable<Destination.Products> {
                        ProductsRoot(
                            onBackClicked = {
                                navController.popBackStack()
                            }
                        )
                    }

                    composable<Destination.Search> {
                        SearchRoot(
                            onBackClicked = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}
