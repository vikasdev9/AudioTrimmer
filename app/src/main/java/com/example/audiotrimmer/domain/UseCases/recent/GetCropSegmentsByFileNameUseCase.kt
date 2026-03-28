package com.example.audiotrimmer.domain.UseCases.recent

import com.example.audiotrimmer.data.room.entity.CropSegmentTable
import com.example.audiotrimmer.domain.Repository.RecentRepository
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCropSegmentsByFileNameUseCase @Inject constructor(
    private val repository: RecentRepository
) {
    suspend operator fun invoke(fileName: String): Flow<ResultState<List<CropSegmentTable>>> {
        return repository.getCropSegmentsByFileName(fileName = fileName)
    }
}