package com.chapeaumoineau.pixelinvasion.data.model

data class Map(
    val map: Array<Array<Pixel>> = emptyArray(),
) {

    companion object {
        fun generateMap(grid: Grid, pixelNumber: Int): Map {
            val newMap = Array(grid.x) { Array(grid.y) { Pixel.getRandomPixel(pixelNumber) } }
            return Map(newMap)
        }
    }

}