package com.chapeaumoineau.pixelinvasion.ui

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Game: Screen("game")
}