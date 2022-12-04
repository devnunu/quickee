package com.devnunu.quickee.ui

data class MainState(
    val inputValue: String? = null,
    val selectedItem: String? = null,
    val itemList: List<String> = emptyList()
) {
}