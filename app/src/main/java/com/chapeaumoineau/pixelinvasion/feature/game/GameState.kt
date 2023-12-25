package com.chapeaumoineau.pixelinvasion.feature.game

import com.chapeaumoineau.pixelinvasion.data.model.Grid
import com.chapeaumoineau.pixelinvasion.data.model.Map
import com.chapeaumoineau.pixelinvasion.data.model.Pixel

data class GameState(
    val player: Int = 0,
    val map: Map = Map(),
    val grid: Grid = Grid(27, 46),
    val pixelNumber: Int = 6,
    val playersPixels: List<Pixel> = emptyList(),
    val endGame: EndGame? = null,
    val pixelSet: Array<Pixel> = Pixel.COLOR_SET_6.toTypedArray()
) {
    fun nextPlayer(): Int = if (player == 0) 1 else 0
}

data class EndGame(
    val player0Score: Int,
    val player1Score: Int
)