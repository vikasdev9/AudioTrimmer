package com.example.audiotrimmer.presentation.ViewModel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.media3.exoplayer.ExoPlayer
import com.example.audiotrimmer.core.MediaPlayerManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MediaPlayerViewModel @Inject constructor(private val mediaPlayerManager: MediaPlayerManager) : ViewModel() {

    fun initializePlayer(uri: Uri) {
        return mediaPlayerManager.initializePlayer(uri)
    }
    fun getPlayer(): ExoPlayer{
        return mediaPlayerManager.getPlayer()
    }

    fun releasePlayer() {
        return mediaPlayerManager.releasePlayer()
    }

    override fun onCleared() {
        super.onCleared()
        mediaPlayerManager.releasePlayer()
    }
}