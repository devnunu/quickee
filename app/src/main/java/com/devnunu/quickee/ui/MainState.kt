package com.devnunu.quickee.ui

data class MainState(
    val isInputMode: Boolean = false,
    val inputValue: String? = null,
    val itemList: List<String> = emptyList()
) {
}