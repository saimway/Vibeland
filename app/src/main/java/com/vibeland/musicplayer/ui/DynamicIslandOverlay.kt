package com.vibeland.musicplayer.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FastForward
import androidx.compose.material.icons.filled.FastRewind
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DynamicIslandOverlay() {
    var isExpanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            .clip(RoundedCornerShape(30.dp))
            .background(Color.Black)
            .clickable { isExpanded = !isExpanded }
            .padding(if (isExpanded) 16.dp else 8.dp),
        contentAlignment = Alignment.Center
    ) {
        if (!isExpanded) {
            // Collapsed State (Pill)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(30.dp).padding(horizontal = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color.DarkGray)
                )
                Spacer(modifier = Modifier.width(12.dp))
                // Minimalist wave visualizer placeholder
                Row(modifier = Modifier.width(30.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
                    repeat(3) {
                        Box(modifier = Modifier.width(3.dp).height(10.dp).background(Color.Magenta))
                    }
                }
            }
        } else {
            // Expanded State
            Column(
                modifier = Modifier.width(300.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.DarkGray)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Song Title", color = Color.White, fontSize = 16.sp)
                        Text("Artist Name", color = Color.Gray, fontSize = 14.sp)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                // Progress Bar
                Box(modifier = Modifier.fillMaxWidth().height(4.dp).background(Color.DarkGray)) {
                    Box(modifier = Modifier.fillMaxWidth(0.4f).fillMaxHeight().background(Color.White))
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(Icons.Default.FastRewind, contentDescription = null, tint = Color.White)
                    Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.White)
                    Icon(Icons.Default.FastForward, contentDescription = null, tint = Color.White)
                }
            }
        }
    }
}
