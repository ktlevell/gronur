package com.gronur.shared.components.progress

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gronur.shared.theme.BG3
import com.gronur.shared.theme.Black
import com.gronur.shared.theme.GronurTheme
import com.gronur.shared.theme.White

@Composable
fun StepperIndicator(
    modifier: Modifier = Modifier,
    totalSteps: Int = 3,
    currentStep: Int = 0,
    activeColor: Color = White,
    inactiveColor: Color = BG3,
    spacing: Dp = 8.dp
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spacing),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(totalSteps) { index ->
            val isSelected = index == currentStep

            val width by animateDpAsState(
                targetValue = if (isSelected) 42.dp else 8.dp,
                animationSpec = tween(
                    durationMillis = 550,
                    easing = FastOutSlowInEasing
                ),
                label = "widthAnimation"
            )

            Box(
                modifier = Modifier
                    .size(width = width, height = 8.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) activeColor else inactiveColor)
            )

        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF19253D)
fun StepProgressHorizontalIndicatorPreview() {
    GronurTheme {
        var currentStep by remember { mutableIntStateOf(0) }
        val totalSteps = 3

        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            StepperIndicator(
                totalSteps = totalSteps,
                currentStep = currentStep
            )

        }
    }
}