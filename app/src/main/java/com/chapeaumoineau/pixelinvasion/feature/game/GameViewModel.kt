package com.chapeaumoineau.pixelinvasion.feature.game

import android.util.Log
import androidx.lifecycle.ViewModel
import com.chapeaumoineau.pixelinvasion.data.model.Map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(): ViewModel() {

    private val _state = MutableStateFlow(GameState())
    val state = _state.asStateFlow()

    var currentPlayer = 0

    init {
        _state.update { it.copy(map = Map.generateMap(_state.value.grid, _state.value.pixelNumber), player = currentPlayer) }
        _state.update { it.copy(playersPixels = _state.value.map.getPlayersPixel()) }
    }

    fun onEvent(event: GameEvent) {
        when (event) {
            is GameEvent.PlayerAction -> {
                if (event.player == currentPlayer) {
                    currentPlayer = _state.value.nextPlayer()
                    _state.update { it.copy(map = _state.value.map.changeMap(event.player, event.pixel)) }
                    _state.update { it.copy(playersPixels = _state.value.map.getPlayersPixel(), player = currentPlayer) }
                }
                if (_state.value.map.isGameOver()) {
                    val player0 = _state.value.map.getPlayerScore(0)
                    val player1 = _state.value.map.getPlayerScore(1)
                    _state.update { it.copy(endGame = EndGame(player0, player1)) }
                }
            }
        }
    }

}