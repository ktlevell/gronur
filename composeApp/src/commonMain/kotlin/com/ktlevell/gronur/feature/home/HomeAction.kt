package com.ktlevell.gronur.feature.home

sealed interface HomeAction {
    data class OnCategorySelected(val id: Int) : HomeAction
    data class OnProductClicked(val id: Int) : HomeAction
    data class OnAddProductClicked(val id: Int, val quantity: Int) : HomeAction
    data object OnSearchClicked : HomeAction
}
