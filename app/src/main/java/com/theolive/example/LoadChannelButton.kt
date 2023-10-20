package com.theolive.example

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.theolive.player.Player
import kotlinx.coroutines.launch

@Composable
fun LoadChannelButton(player: Player?, channelId: String) {
    val scope = rememberCoroutineScope()
    ListItem(
        headlineContent = {
            Text(MainActivity.channelId)
        },
        modifier = Modifier.clickable {
            scope.launch {
                player?.loadChannel(channelId)
            }
        },
        leadingContent = {
            Icon(Icons.Rounded.Favorite, contentDescription = null)
        },
    )
}
