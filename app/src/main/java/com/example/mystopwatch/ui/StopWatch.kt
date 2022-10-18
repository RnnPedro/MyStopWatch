package com.example.mystopwatch.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.*
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class StopWatch {
    var isTimeRunning by mutableStateOf(false)
    var formattedTime by mutableStateOf("00:00:00")

    private var lastTimestamp by mutableStateOf(0L)
    private var timeCount = 0L
    private var coroutineScope = CoroutineScope(Dispatchers.Main)

    fun onClickStart(){
        isTimeRunning = !isTimeRunning

        if (isTimeRunning) {

            lastTimestamp =
                if (timeCount > 0L){
                    System.currentTimeMillis() - timeCount
                } else
                    System.currentTimeMillis()

            coroutineScope.launch {
                while (isTimeRunning) {
                    delay(100L)
                    timeCount = System.currentTimeMillis() - lastTimestamp
                    formattedTime = formatTime(timeCount)

                }
            }
        }
    }

    private fun formatTime(totalMillis: Long): String {

        val localDateTime = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(totalMillis),
            ZoneId.of("UTC")
        )
        val formatter = DateTimeFormatter.ofPattern(
            "HH:mm:ss",
            Locale.getDefault()
        )

        return localDateTime.format(formatter)
    }

    fun onClickReset (){
        coroutineScope.cancel()
        coroutineScope = CoroutineScope(Dispatchers.Main)
        isTimeRunning = false
        formattedTime = "00:00:00"
        lastTimestamp = 0L
        timeCount     = 0L
    }


}