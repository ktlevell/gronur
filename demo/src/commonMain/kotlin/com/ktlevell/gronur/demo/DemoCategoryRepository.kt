package com.ktlevell.gronur.demo

import com.ktlevell.gronur.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.ExperimentalResourceApi
import gronur.demo.generated.resources.Res

@OptIn(ExperimentalResourceApi::class)
class DemoCategoryRepository : CategoryRepository {
    private val json = Json {
        ignoreUnknownKeys = true
    }

    override fun getCategories(): Flow<List<Category>> = flow {
        try {
            val bytes = Res.readBytes("files/categories.json")
            val content = bytes.decodeToString()
            val response = json.decodeFromString<CategoriesResponse>(content)

            val mappedCategories = response.categories.map { category ->
                category.copy(
                    products = category.products.map { product ->
                        product.copy(imageUrl = product.imageUrl)
                    }
                )
            }
            
            emit(mappedCategories)
        } catch (e: Exception) {
            e.printStackTrace()
            emit(emptyList())
        }
    }
}
