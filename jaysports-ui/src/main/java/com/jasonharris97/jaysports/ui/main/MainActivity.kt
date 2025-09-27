package com.jasonharris97.jaysports.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.jasonharris97.jaysports.ui.theme.JaySportsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            JaySportsTheme {
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.Companion.padding(innerPadding)
                    ) {
                        Text(text = "Hello World!")
                    }
                }
            }
        }
    }
}