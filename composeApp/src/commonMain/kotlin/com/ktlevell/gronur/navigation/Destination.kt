package com.ktlevell.gronur.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.painter.Painter
import com.gronur.shared.theme.GronurIcons
import kotlinx.serialization.Serializable

val LocalCurrentDestination = compositionLocalOf<Destination> {
    Destination.Home
}

val LocalOnDestinationClicked = compositionLocalOf<(Destination) -> Unit> {
    {}
}

@Serializable
sealed interface Destination {
    val isRoot: Boolean
    val title: String? get() = null

    @Serializable
    data object Home : Destination {
        override val isRoot = true
        override val title = "Home"
    }

    @Serializable
    data object Order : Destination {
        override val isRoot = true
        override val title = "Order"
    }

    @Serializable
    data object Cart : Destination {
        override val isRoot = true
        override val title = "My Cart"
    }

    @Serializable
    data object More : Destination {
        override val isRoot = true
        override val title = "More"
    }

    companion object {

        @Composable
        fun getIcon(destination: Destination): Painter {
            return when (destination) {
                is Home -> GronurIcons.home()
                is Order -> GronurIcons.store()
                is Cart -> GronurIcons.cart()
                is More -> GronurIcons.more()
            }
        }

        val rootDestinations: List<Destination>
            get() = listOf(
                Home,
                Order,
                Cart,
                More
            )
    }
}