package com.vibeland.musicplayer.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FastForward
import androidx.compose.material.icons.filled.FastRewind
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vibeland.musicplayer.model.Song

@Composable
fun PlayerScreen(song: Song, onBack: () -> Unit) {
    val bgColor = Color(0xFF2E1A47)
    val gradient = Brush.verticalGradient(
        colors = listOf(bgColor, Color.Black)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(48.dp))

        Box(
            modifier = Modifier
                .size(320.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color.DarkGray)
        )

        Spacer(modifier = Modifier.height(48.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(song.title, color = Color.White, fontSize = 24.sp)
            Text(song.artist, color = Color.Gray, fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(48.dp))

        Box(modifier = Modifier.fillMaxWidth().height(4.dp).clip(RoundedCornerShape(2.dp)).background(Color.DarkGray)) {
            Box(modifier = Modifier.fillMaxWidth(0.6f).fillMaxHeight().background(Color.White))
        }

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.FastRewind, contentDescription = null, tint = Color.White, modifier = Modifier.size(36.dp))
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(35.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.Black, modifier = Modifier.size(40.dp))
            }
            Icon(Icons.Default.FastForward, contentDescription = null, tint = Color.White, modifier = Modifier.size(36.dp))
        }
    }
}
