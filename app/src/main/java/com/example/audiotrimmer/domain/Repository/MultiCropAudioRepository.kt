package com.example.audiotrimmer.domain.Repository

import android.content.Context
import com.example.audiotrimmer.data.DataClass.CropSegment
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import kotlinx.coroutines.flow.Flow


interface MultiCropAudioRepository {

    suspend fun multiCropAudio(context: Context, uri: String, segments: List<CropSegment>, filename: String): Flow<ResultState<String>>

}