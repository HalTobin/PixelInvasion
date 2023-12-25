package com.chapeaumoineau.pixelinvasion.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chapeaumoineau.pixelinvasion.R
import com.chapeaumoineau.pixelinvasion.ui.Screen

@Composable
fun HomeScreen(
    navController: NavController
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Button(onClick = { navController.navigate(Screen.Game.route) }) {
                Text(text = stringResource(id = R.string.new_game).uppercase())
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate(Screen.Settings.route) }) {
                Text(text = stringResource(id = R.string.settings).uppercase())
            }
        }
    }

}