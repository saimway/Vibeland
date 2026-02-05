package com.vibeland.musicplayer.ui

import androidx.compose.runtime.*
import com.vibeland.musicplayer.model.Song

@Composable
fun VibelandApp() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Library) }

    when (val screen = currentScreen) {
        is Screen.Library -> LibraryScreen(onSongClick = { currentScreen = Screen.Player(it) })
        is Screen.Player -> PlayerScreen(song = screen.song, onBack = { currentScreen = Screen.Library })
    }
}
