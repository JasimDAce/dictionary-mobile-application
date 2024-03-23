package com.example.dictionary.presentation

sealed class MainUiEvents {
    data class OnSearchWordChange(
        val newWord : String
    ): MainUiEvents()
    object OnSearchClick: MainUiEvents()
}