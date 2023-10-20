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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.theolive.example.ui.theme.ExampleTheme
import com.theolive.internal.player.PlayerImpl
import com.theolive.player.Player
import com.theolive.player.PlayerView

class ActivityWithTHEOliveChromeless : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContent {
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
                        val player = rememberPlayer(modifier = Modifier.aspectRatio(16f / 9))
                        // A button to load a channel into the player.
                        Label(text = "Press this button to load the channel:")
                        LoadChannelButton(player = player, channelId = MainActivity.channelId)
                    }
                }
            }
        }
    }
}

@Composable
fun rememberPlayer(
    modifier: Modifier
): Player? {
    var player: PlayerImpl? by remember { mutableStateOf(null) }
    AndroidView(
        modifier = modifier,
        factory = {
            val view = PlayerView(it)
            player = view.player
            view
        },
        update = {
            player = it.player
        }
    )
    return player
}
