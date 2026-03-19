package com.example.audiotrimmer.domain.Repository

import android.content.Context
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import kotlinx.coroutines.flow.Flow

interface ConvertAudioFormatRepository {
    suspend fun convertAudioFormat(
        context: Context,
        uri: String,
        outputMimeType: String,
        outputExtension: String,
        filename: String
    ): Flow<ResultState<String>>
}