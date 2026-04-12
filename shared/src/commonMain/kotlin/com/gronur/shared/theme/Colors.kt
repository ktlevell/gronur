package com.gronur.shared.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

/**
 * Background colors
 */
val BG1 = Color(0xFFC1C7D0)
val BG2 = Color(0xFFF3F3F3)
val BG3 = Color(0xFFFAFBFC)
val BG4 = Color(0xFFFFFFFF)


/**
 * Typography colors
 */
val Text1 = Color(0xFF0E1725)
val Text2 = Color(0xFFA5B6DA)
val Text3 = Color(0xFFC9D3E9)
val Text4 = Color(0xFFEDF0F8)


/**
 * Move colors
 */
val Primary0100 = Color(0xFFFF19253D)
val Primary075 = Color(0xFFFF25375A)
val Primary050 = Color(0xFFFF344D7F)
val Primary025 = Color(0xFFFF8099CB)

val Secondary0100 = Color(0xFFFFF6C3D)
val Secondary075 = Color(0xFFFFFF9E80)
val Secondary050 = Color(0xFFFFFFC5B3)
val Secondary025 = Color(0xFFFFFFECE5)

val Tertiary0100 = Color(0xFFF6AC469)
val Tertiary075 = Color(0xFFFFA4DBA3)
val Tertiary50 = Color(0xFFFC8E9C8)
val Tertiary025 = Color(0xFFFFEDF8ED)

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF010101)



val LightColorScheme = lightColorScheme(
    primary = Primary0100,
    onPrimary = White,
    onPrimaryFixedVariant = Black,
    background = White,
    secondary = Secondary0100,
    onSecondary = White,
    surface = BG3,
    onSurface = Black,
    onSurfaceVariant = BG3,
    tertiary = Tertiary0100,
)
