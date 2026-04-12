package com.ktlevell.gronur.demo

import androidx.compose.runtime.Immutable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Immutable
data class Category(
    val id: Int,
    val name: String,
    val products: List<Product> = emptyList(),
    val isSelected: Boolean = false
)

@Serializable
@Immutable
data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    @SerialName("old_price")
    val oldPrice: Double? = null,
    val unit: String? = null,
    val description: String? = null,
    @SerialName("product_url")
    val imageUrl: String? = null,
    val calories: Int? = null
)

@Serializable
@Immutable
data class CategoriesResponse(
    val categories: List<Category>
)
