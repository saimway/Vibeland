package com.vibeland.musicplayer.ui

import com.vibeland.musicplayer.model.Song

sealed class Screen {
    object Library : Screen()
    data class Player(val song: Song) : Screen()
}
