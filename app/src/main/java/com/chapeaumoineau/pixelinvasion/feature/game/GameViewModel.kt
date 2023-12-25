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
class GameViewModel @Inject constructor(

): ViewModel() {

    private val _state = MutableStateFlow(GameState())
    val state = _state.asStateFlow()

    init {
        _state.update { it.copy(map = Map.generateMap(_state.value.grid, _state.value.pixelNumber)) }
        Log.i("MAP", "X size: ${_state.value.map.map.size}, Y size: ${_state.value.map.map[0].size}")
    }

    fun onEvent(event: GameEvent) {
        when (event) {

        }
    }

}