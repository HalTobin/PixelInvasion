package com.chapeaumoineau.pixelinvasion.feature.game

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chapeaumoineau.pixelinvasion.data.model.Pixel
import kotlin.math.min

@Composable
fun GameScreen(
    navController: NavController,
    state: GameState,
    onEvent: (GameEvent) -> Unit
) {

    Column(modifier = Modifier.fillMaxSize()) {

        PlayerControls(player = 1, pixels = state.pixelSet, onClick = { pixel, player -> })
        Divider(modifier = Modifier.fillMaxWidth())

        Canvas(modifier = Modifier.weight(1f).fillMaxWidth()) {
            val xMax = size.width / state.map.map.size
            val yMax = size.height / state.map.map[0].size
            val cellSize = min(xMax, yMax)
            state.map.map.forEachIndexed { indexX, row ->
                row.forEachIndexed { indexY, cell ->
                    drawRect(
                        topLeft = Offset(x = indexX * cellSize, y = indexY * cellSize),
                        color = Color(cell.color),
                        size = Size(cellSize, cellSize)
                    )
                }
            }
        }

        Divider(modifier = Modifier.fillMaxWidth())
        PlayerControls(player = 1, pixels = state.pixelSet, onClick = { pixel, player -> })

    }

}

@Composable
fun PlayerControls(
    player: Int,
    pixels: Array<Pixel>,
    onClick: (Pixel, Int) -> Unit
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp),
    horizontalArrangement = Arrangement.SpaceAround
) {

    pixels.forEach { pixel ->
        Box(modifier = Modifier.composed {
            size(40.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(Color(pixel.color))
                .clickable { onClick(pixel, player) }
        })
    }

}