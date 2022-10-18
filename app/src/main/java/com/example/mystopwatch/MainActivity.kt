package com.example.mystopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.mystopwatch.ui.MainScreen
import com.example.mystopwatch.ui.theme.MyStopWatchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyStopWatchTheme {
                val stopWatch = remember { StopWatch() }
                MainScreen(
                    stopWatch.formattedTime,
                    stopWatch.isTimeRunning,
                    stopWatch::onClickStart,
                    stopWatch::onClickReset)
            }
        }
    }
}