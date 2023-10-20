package com.theolive.example

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.theolive.example.ui.theme.ExampleTheme

class MainActivity : ComponentActivity() {

    companion object {
        // Replace this with your own channelId
        const val channelId = "my-channel-id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContent {
            // The THEOlive player API.
            val context = LocalContext.current
            ExampleTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Title(text = "Select a THEOlive example:")
                        OpenActivityButton(
                            text = "Example with THEOliveUI",
                            intent = Intent(
                                context,
                                ActivityWithTHEOliveUI::class.java
                            )
                        )
                        OpenActivityButton(
                            text = "Example with THEOliveChromeless",
                            intent = Intent(
                                context,
                                ActivityWithTHEOliveChromeless::class.java
                            )
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun OpenActivityButton(text: String, intent: Intent) {
    val context = LocalContext.current
    ListItem(
        headlineContent = {
            Text(text)
        },
        modifier = Modifier.clickable {
            context.startActivity(intent)
        },
        leadingContent = {
            Icon(Icons.Rounded.Favorite, contentDescription = null)
        },
    )
}

