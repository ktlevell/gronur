package com.ktlevell.gronur.feature.home

import androidx.compose.runtime.Immutable
import com.ktlevell.gronur.demo.Category
import com.ktlevell.gronur.demo.Product

@Immutable
data class HomeUiState(
    val isLoading: Boolean = false,
    val categories: List<Category> = emptyList(),
    val products: List<Product> = emptyList(),
    val selectedCategory: Category? = null
)
