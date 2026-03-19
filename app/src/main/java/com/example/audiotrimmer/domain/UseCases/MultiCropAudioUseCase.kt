package com.example.audiotrimmer.domain.UseCases

import android.content.Context
import com.example.audiotrimmer.data.DataClass.CropSegment
import com.example.audiotrimmer.domain.Repository.MultiCropAudioRepository
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MultiCropAudioUseCase @Inject constructor(
    private val repository: MultiCropAudioRepository
) {

    suspend operator fun invoke(
        context: Context,
        uri: String,
        segments: List<CropSegment>,
        filename: String
    ): Flow<ResultState<String>> {
        return repository.multiCropAudio(
            context = context,
            uri = uri,
            segments = segments,
            filename = filename
        )
    }
}