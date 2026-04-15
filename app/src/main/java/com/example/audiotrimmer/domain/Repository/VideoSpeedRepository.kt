package com.example.audiotrimmer.domain.Repository

import android.net.Uri
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import kotlinx.coroutines.flow.Flow

interface VideoSpeedRepository {
    suspend fun ChangeVideoSpeed(
        uri: Uri,
        speed: Float,
        filename: String
    ): Flow<ResultState<String>>
}