package com.devnunu.quickee.ui

data class MainState(
    val inputValue: String? = null,
    val itemList: List<String> = emptyList()
) {
}