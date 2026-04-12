package com.ktlevell.gronur

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.gronur.shared.theme.GronurTheme
import com.ktlevell.gronur.feature.home.HomeRoot
import com.ktlevell.gronur.navigation.NavigationRoot

@Composable
@Preview
fun App() {
    GronurTheme {
        NavigationRoot(
            navController = rememberNavController()
        )
    }
}