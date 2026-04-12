package com.ktlevell.gronur

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.gronur.shared.theme.GronurTheme
import com.ktlevell.gronur.navigation.NavigationHost

@Composable
@Preview
fun App() {
    GronurTheme {
        NavigationHost(
            navController = rememberNavController()
        )
    }
}