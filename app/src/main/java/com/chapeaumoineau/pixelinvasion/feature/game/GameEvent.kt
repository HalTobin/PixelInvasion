package com.chapeaumoineau.pixelinvasion.feature.game

import com.chapeaumoineau.pixelinvasion.data.model.Pixel

sealed class GameEvent {
    data class PlayerAction(val player: Int, val pixel: Pixel): GameEvent()
}