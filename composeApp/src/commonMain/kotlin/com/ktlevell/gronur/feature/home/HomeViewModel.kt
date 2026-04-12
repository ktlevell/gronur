package com.ktlevell.gronur.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ktlevell.gronur.demo.DemoCategoryRepository
import com.ktlevell.gronur.repository.CategoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val categoryRepository: CategoryRepository = DemoCategoryRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HomeUiState()
        )

    init {
        loadHomeData()
    }

    fun onAction(action: HomeAction) {
        when (action) {
            is HomeAction.OnCategorySelected -> {
                _state.update { currentState ->
                    val selectedCat = currentState.categories.find { it.id == action.id }
                    currentState.copy(
                        categories = currentState.categories.map {
                            it.copy(isSelected = it.id == action.id)
                        },
                        selectedCategory = selectedCat,
                        products = selectedCat?.products ?: emptyList()
                    )
                }
            }
            is HomeAction.OnProductClicked -> {}
            is HomeAction.OnAddProductClicked -> {}
            is HomeAction.OnSearchClicked -> {

            }
        }
    }

    private fun loadHomeData() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            categoryRepository.getCategories().collectLatest { categories ->
                _state.update {
                    val firstCategory = categories.firstOrNull()?.copy(isSelected = true)
                    val updatedCategories = categories.map { 
                        if (it.id == firstCategory?.id) firstCategory else it 
                    }
                    it.copy(
                        isLoading = false,
                        categories = updatedCategories,
                        products = firstCategory?.products ?: emptyList(),
                        selectedCategory = firstCategory
                    )
                }
            }
        }
    }
}
