package com.example.mystopwatch.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    formattedTime: String,
    isTimeRunning: Boolean,
    onClickStartStop: () -> Unit,
    onClickReset: () -> Unit) {

    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(formattedTime)

            Spacer(modifier = Modifier.height(30.dp))

            Row{
                Button(modifier = Modifier
                    .width(90.dp),
                    onClick = { onClickStartStop() }
                ) {
                    if (!isTimeRunning) Text("Start")
                    else Text("Stop")
                }

                Spacer(modifier = Modifier.width(15.dp))

                Button(modifier = Modifier
                    .width(90.dp),
                    onClick = { onClickReset() }
                ){
                    Text("Restart")
                }
            }
        }
    }
}