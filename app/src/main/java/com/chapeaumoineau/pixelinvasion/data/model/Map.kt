package com.chapeaumoineau.pixelinvasion.data.model

import android.util.Log

data class Map(
    val map: Array<Array<Pixel>> = emptyArray(),
) {

    fun changeMap(player: Int, pixel: Pixel): Map {
        val rowIndex: Int
        val colIndex: Int

        val newMap = map.clone()

        // Determine the player's position
        if (player == 1) {
            rowIndex = 0
            colIndex = map[0].size - 1
        } else {
            rowIndex = map.size - 1
            colIndex = 0
        }
        val originalPixel = map[rowIndex][colIndex]

        // Change the value of the starting cell
        newMap[rowIndex][colIndex] = pixel

        // Update adjacent cells with the same value
        updateAdjacentCells(newMap, rowIndex, colIndex, pixel, originalPixel)

        Log.i("MAP", "Map has been updated!")

        return Map(newMap)
    }

    private fun updateAdjacentCells(newMap: Array<Array<Pixel>>, row: Int, col: Int, newPixel: Pixel, originalPixel: Pixel) {
        // Define the indices of adjacent cells
        val adjacentIndices = listOf(
            Pair(row - 1, col),
            Pair(row + 1, col),
            Pair(row, col - 1),
            Pair(row, col + 1)
        )

        // Update adjacent cells with the same value and belonging to the same player
        for ((adjRow, adjCol) in adjacentIndices) {
            if (isValidIndex(adjRow, adjCol) && map[adjRow][adjCol] == originalPixel) {
                newMap[adjRow][adjCol] = newPixel
                // Recursively update adjacent cells of the same color and belonging to the same player
                updateAdjacentCells(newMap, adjRow, adjCol, newPixel, originalPixel)
            }
        }
    }

    private fun isValidIndex(row: Int, col: Int): Boolean {
        return row in 0 until map.size && col in 0 until map[0].size
    }

    companion object {
        fun generateMap(grid: Grid, pixelNumber: Int): Map {
            val newMap = Array(grid.x) { Array(grid.y) { Pixel.getRandomPixel(pixelNumber) } }
            return Map(newMap)
        }

    }

}