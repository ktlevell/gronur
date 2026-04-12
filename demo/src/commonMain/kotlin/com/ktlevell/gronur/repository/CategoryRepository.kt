package com.ktlevell.gronur.repository

import com.ktlevell.gronur.demo.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getCategories(): Flow<List<Category>>
}
