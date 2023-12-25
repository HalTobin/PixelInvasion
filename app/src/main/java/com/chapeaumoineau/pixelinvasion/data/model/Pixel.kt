package com.chapeaumoineau.pixelinvasion.data.model

import android.graphics.Color
import kotlin.random.Random

sealed class Pixel(val color: Int) {
    object Alpha: Pixel(color = Color.BLUE)
    object Beta: Pixel(color = Color.RED)
    object Gamma: Pixel(color = Color.YELLOW)
    object Delta: Pixel(color = Color.GREEN)
    object Epsilon: Pixel(color = 0xFFFFA500.toInt())
    object Zeta: Pixel(color = Color.CYAN)
    object Theta: Pixel(color = Color.WHITE)

    companion object {
        val COLOR_SET_4 = listOf(Alpha, Beta, Gamma, Delta)
        val COLOR_SET_5 = listOf(Alpha, Beta, Gamma, Delta, Epsilon)
        val COLOR_SET_6 = listOf(Alpha, Beta, Gamma, Delta, Epsilon, Zeta)
        val COLOR_SET_7 = listOf(Alpha, Beta, Gamma, Delta, Epsilon, Zeta, Theta)

        private fun getFromInt(value: Int): Pixel {
            return when (value) {
                1 -> Alpha
                2 -> Beta
                3 -> Gamma
                4 -> Delta
                5 -> Epsilon
                6 -> Zeta
                7 -> Theta
                else -> { throw IllegalArgumentException() }
            }
        }

        fun getRandomPixel(pixelNumber: Int): Pixel = getFromInt(Random.nextInt(1, pixelNumber))
    }

}