package com.chapeaumoineau.pixelinvasion.feature.game

import com.chapeaumoineau.pixelinvasion.data.model.Grid
import com.chapeaumoineau.pixelinvasion.data.model.Map
import com.chapeaumoineau.pixelinvasion.data.model.Pixel

data class GameState(
    val map: Map = Map(),
    val grid: Grid = Grid(27, 46),
    val pixelNumber: Int = 6,
    val pixelSet: Array<Pixel> = Pixel.COLOR_SET_6.toTypedArray()
)