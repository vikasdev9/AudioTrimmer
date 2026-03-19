package com.example.audiotrimmer.domain.Repository

import android.content.Context
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import kotlinx.coroutines.flow.Flow

interface RecordAudioRepository {
    suspend fun startRecording(context: Context, filename: String): Flow<ResultState<String>>
    fun pauseRecording()
    fun resumeRecording()
    suspend fun stopRecording(context: Context): Flow<ResultState<String>>
    fun isRecording(): Boolean
    fun isPaused(): Boolean
}