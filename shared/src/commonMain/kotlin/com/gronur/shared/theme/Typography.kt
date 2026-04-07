package com.gronur.shared.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import gronur.shared.generated.resources.Inter_18pt_Bold
import gronur.shared.generated.resources.Inter_18pt_Light
import gronur.shared.generated.resources.Inter_18pt_Medium
import gronur.shared.generated.resources.Inter_18pt_Regular
import gronur.shared.generated.resources.Inter_18pt_SemiBold
import gronur.shared.generated.resources.Res
import org.jetbrains.compose.resources.Font

val Inter @Composable get() = FontFamily(
    Font(Res.font.Inter_18pt_Light, FontWeight.Light),
    Font(Res.font.Inter_18pt_Regular, FontWeight.Normal),
    Font(Res.font.Inter_18pt_Medium, FontWeight.Medium),
    Font(Res.font.Inter_18pt_SemiBold, FontWeight.SemiBold),
    Font(Res.font.Inter_18pt_Bold, FontWeight.Bold)
)


val Typography @Composable get() = Typography(
    headlineLarge = TextStyle(
        fontFamily = Inter,
        fontSize = FontSize.EXTRA_LARGE,
        fontWeight = FontWeight.Bold
    ),
    headlineMedium = TextStyle(
        fontFamily = Inter,
        fontSize = FontSize.LARGE,
        fontWeight = FontWeight.SemiBold
    ),
    headlineSmall = TextStyle(
        fontFamily = Inter,
        fontSize = FontSize.EXTRA_MEDIUM,
        fontWeight = FontWeight.SemiBold
    ),
    titleLarge = TextStyle(
        fontFamily = Inter,
        fontSize = FontSize.EXTRA_MEDIUM,
        fontWeight = FontWeight.Medium
    ),
    titleMedium = TextStyle(
        fontFamily = Inter,
        fontSize = FontSize.MEDIUM,
        fontWeight = FontWeight.Medium
    ),
    titleSmall = TextStyle(
        fontFamily = Inter,
        fontSize = FontSize.EXTRA_REGULAR,
        fontWeight = FontWeight.Medium
    ),
    bodyLarge = TextStyle(
        fontFamily = Inter,
        fontSize = FontSize.EXTRA_REGULAR,
        fontWeight = FontWeight.Normal
    ),
    bodyMedium = TextStyle(
        fontFamily = Inter,
        fontSize = FontSize.REGULAR,
        fontWeight = FontWeight.Normal
    ),
    bodySmall = TextStyle(
        fontFamily = Inter,
        fontSize = FontSize.SMALL,
        fontWeight = FontWeight.Normal
    ),
    labelLarge = TextStyle(
        fontFamily = Inter,
        fontSize = FontSize.SMALL,
        fontWeight = FontWeight.Medium
    ),
    labelSmall = TextStyle(
        fontFamily = Inter,
        fontSize = FontSize.EXTRA_SMALL,
        fontWeight = FontWeight.Medium
    )
)