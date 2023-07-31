package com.theolive.example

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.theolive.example.ui.theme.ExampleTheme
import com.theolive.player.api.THEOliveChromeless
import com.theolive.player.api.rememberTHEOlivePlayer

class ActivityWithTHEOliveUI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContent {
            // The THEOlive player API.
            val player = rememberTHEOlivePlayer()
            ExampleTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        // The title of the activity.
                        Title(
                            "THEOlive Chromeless",
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        // The THEOlive player view, with the default UI.
                        THEOliveChromeless(
                            player = player,
                            modifier = Modifier.aspectRatio(16f / 9)
                        )
                        // A button to load a channel into the player.
                        LoadChannelButton(player = player, channelId = MainActivity.channelId)
                    }
                }
            }
        }
    }
}
