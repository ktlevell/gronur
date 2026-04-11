package com.gronur.shared.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.gronur.shared.components.buttons.CircleAddItem
import com.gronur.shared.theme.BG1
import com.gronur.shared.theme.GronurTheme
import gronur.shared.generated.resources.Res
import gronur.shared.generated.resources.it_watermelon
import org.jetbrains.compose.resources.painterResource

@Composable
fun ItemCard(
    onItemClick: () -> Unit,
    onAddItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val price = "10.45"
    val unit = "kg"
    val annotatedPrice = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.secondary,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                fontWeight = FontWeight.SemiBold
            )
        ) {
            append("$${price}")
        }

        withStyle(
            style = SpanStyle(
                color = BG1,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                fontWeight = FontWeight.SemiBold
            )
        ) {
            append("/${unit}")
        }
    }

    Card(
        modifier = Modifier
            .width(175.dp)
            .height(230.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally)
                ,
                painter = painterResource(Res.drawable.it_watermelon),
                contentDescription = "Image Fruit",
                contentScale = ContentScale.Crop
            )

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                val (
                    categoryRef,
                    caloriesRef,
                    priceRef,
                    addCategoryRef
                ) = createRefs()

                Text(
                    modifier = Modifier
                        .constrainAs(categoryRef) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        },
                    text = "Watermelon",
                    style = MaterialTheme.typography.titleSmall
                )

                Text(
                    modifier = Modifier
                        .constrainAs(caloriesRef) {
                            top.linkTo(categoryRef.bottom, margin = 4.dp)
                            start.linkTo(parent.start)
                        },
                    text = "75 cal",
                    style = MaterialTheme.typography.bodySmall,
                    color = BG1
                )

                Text(
                    modifier = Modifier
                        .constrainAs(priceRef) {
                            top.linkTo(caloriesRef.bottom, margin = 24.dp)
                            start.linkTo(parent.start)
                            bottom.linkTo(parent.bottom)
                        },
                    text = annotatedPrice,
                    style = MaterialTheme.typography.titleLarge
                )

                CircleAddItem(
                    modifier = Modifier
                        .constrainAs(addCategoryRef) {
                            top.linkTo(priceRef.top)
                            bottom.linkTo(priceRef.bottom)
                            end.linkTo(parent.end)
                        },
                    onClick = {}
                )
            }
        }
    }
}

@Composable
@Preview
fun ItemCardPreview() {
    GronurTheme {
        ItemCard(
            onItemClick = {},
            onAddItemClick = {}
        )
    }
}