package com.vibeland.musicplayer.ui

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vibeland.musicplayer.model.Song

@Composable
fun LibraryScreen(onSongClick: (Song) -> Unit) {
    val songs = listOf(
        Song(1, "Neon Nights", "Synthwave Boy", "Cyberpunk", 240000, Uri.EMPTY, null),
        Song(2, "Midnight Drive", "The Driver", "Synth", 180000, Uri.EMPTY, null),
        Song(3, "Lo-fi Chill", "Relax Cat", "Chill", 300000, Uri.EMPTY, null)
    )

    Column(modifier = Modifier.fillMaxSize().background(Color(0xFF121212)).padding(16.dp)) {
        Text("Your Library", color = Color.White, fontSize = 28.sp, modifier = Modifier.padding(vertical = 24.dp))
        LazyColumn {
            items(songs) { song ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSongClick(song) }
                        .padding(vertical = 12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.DarkGray)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(song.title, color = Color.White, fontSize = 18.sp)
                        Text(song.artist, color = Color.Gray, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}
