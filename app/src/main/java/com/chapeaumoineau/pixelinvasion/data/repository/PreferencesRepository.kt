package com.chapeaumoineau.pixelinvasion.data.repository

import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesRepository @Inject constructor(
    private val sp: SharedPreferences
) {

    fun reset() {
        pixelNumber = PrefDefault.PIXEL_NUMBER
        gridX = PrefDefault.GRID_X
        gridY = PrefDefault.GRID_Y
    }

    var pixelNumber: Int
        get() = readOption(PrefKey.PIXEL_NUMBER, PrefDefault.PIXEL_NUMBER)
        set(value) {
            if (value > 3 && value < 8) writeOption(PrefKey.PIXEL_NUMBER, value)
        }

    var gridX: Int
        get() = readOption(PrefKey.GRID_X, PrefDefault.GRID_X)
        set(value) = writeOption(PrefKey.GRID_X, value)

    var gridY: Int
        get() = readOption(PrefKey.GRID_Y, PrefDefault.GRID_Y)
        set(value) = writeOption(PrefKey.GRID_Y, value)

    private fun readOption(key: String, default: Int): Int =
        sp.getInt(key, default)

    private fun writeOption(key: String, value: Int) =
        sp.edit().putInt(key, value).apply()

}

object PrefKey {
    const val PIXEL_NUMBER = "pixels_number"
    const val GRID_X = "grid_x"
    const val GRID_Y = "grid_y"
    const val LANGUAGE = "language"
}

object PrefDefault {
    const val PIXEL_NUMBER = 6
    const val GRID_X = 27
    const val GRID_Y = 46
}