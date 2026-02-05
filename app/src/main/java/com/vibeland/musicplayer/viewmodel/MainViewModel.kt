package com.vibeland.musicplayer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vibeland.musicplayer.data.MusicRepository
import com.vibeland.musicplayer.model.Song
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MusicRepository) : ViewModel() {
    private val _songs = MutableStateFlow<List<Song>>(emptyList())
    val songs = _songs.asStateFlow()

    private val _currentSong = MutableStateFlow<Song?>(null)
    val currentSong = _currentSong.asStateFlow()

    fun loadSongs() {
        viewModelScope.launch {
            _songs.value = repository.fetchLocalSongs()
        }
    }

    fun playSong(song: Song) {
        _currentSong.value = song
        // In a real app, we'd communicate with the MediaService here
    }
}
