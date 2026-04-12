package com.ktlevell.gronur.feature.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gronur.shared.components.appbars.NavBackBar
import com.gronur.shared.components.buttons.PrimaryButton
import com.gronur.shared.theme.BG1
import com.gronur.shared.theme.BG3
import com.gronur.shared.theme.GronurTheme
import com.gronur.shared.theme.White

@Composable
fun DetailsRoot(
    id: Int,
    onBackClicked: () -> Unit,
) {
    DetailsScreen(
        onBackClicked = onBackClicked
    )
}

@Composable
fun DetailsScreen(
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
        ,
        topBar = {
            NavBackBar(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp),
                onClick = onBackClicked
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .navigationBarsPadding()
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = White
                            )
                        ) {
                            append("$14.75")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontSize = 16.sp,
                                color = BG1
                            )
                        ) {
                            append("/kg")
                        }
                    }
                )

                PrimaryButton(
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    onClick = {},
                    text = "Add Cart"
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = White
    ) { innerPadding ->

    }
}

@Composable
@Preview
fun DetailsScreenPreview() {
    GronurTheme {
        DetailsScreen(
            onBackClicked = {}
        )
    }
}