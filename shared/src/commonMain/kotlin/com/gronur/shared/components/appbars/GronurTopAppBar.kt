package com.gronur.shared.components.appbars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gronur.shared.theme.GronurTheme

@Composable
fun GronurTopAppBar(
    title: String,
    search: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(140.dp)
        ,
        shape = RoundedCornerShape(0.dp),
        color = MaterialTheme.colorScheme.onPrimary,
        contentColor = MaterialTheme.colorScheme.primary,
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ,
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .weight(1f),
                text = title,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 36.sp,
                    lineHeight = 38.sp,
                    letterSpacing = 0.9.sp
                )
            )

            search()
        }
    }
}

@Composable
@Preview
fun GronurTopAppBarPreview() {
    GronurTheme {
        GronurTopAppBar(
            title = "Daily\nGrocery Food",
            search = {
                CircleSearchBar(
                    modifier = Modifier,
                    onClick = {}
                )
            }
        )
    }
}