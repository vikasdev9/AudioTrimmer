package com.example.audiotrimmer.domain.Repository

import android.content.Context
import android.net.Uri
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import kotlinx.coroutines.flow.Flow

interface AudioTrimmerRepository {
    suspend fun TrimAudio(context: Context, uri: Uri, startTime: Long, endTime: Long, filename: String): Flow<ResultState<String>>
}