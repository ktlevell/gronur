package com.gronur.shared.remember

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import gronur.demo.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.decodeToImageBitmap

@OptIn(ExperimentalResourceApi::class)
@Composable
fun rememberLocalPainter(path: String?): Painter? {
    if (path == null) return null

    var painter by remember(path) { mutableStateOf<Painter?>(null) }

    LaunchedEffect(path) {
        try {
            val bytes = Res.readBytes("files/$path")
            val bitmap = bytes.decodeToImageBitmap()
            painter = BitmapPainter(bitmap)
        } catch (e: Exception) {
            println("Error loading image from files/$path: ${e.message}")
        }
    }

    return painter
}
