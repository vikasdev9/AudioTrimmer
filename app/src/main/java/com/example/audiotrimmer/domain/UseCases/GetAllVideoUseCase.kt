package com.example.audiotrimmer.domain.UseCases


import com.example.audiotrimmer.data.DataClass.Video
import com.example.audiotrimmer.domain.Repository.VideoRepository
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllVideoUseCase @Inject constructor(private val repository: VideoRepository){
    suspend operator  fun invoke(): Flow<ResultState<List<Video>>>{
        return repository.getAllVideos()
    }
}