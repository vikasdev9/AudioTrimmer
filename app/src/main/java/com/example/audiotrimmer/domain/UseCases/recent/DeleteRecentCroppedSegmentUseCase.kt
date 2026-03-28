package com.example.audiotrimmer.domain.UseCases.recent


import com.example.audiotrimmer.data.room.entity.CropSegmentTable
import com.example.audiotrimmer.domain.Repository.RecentRepository
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeleteRecentCroppedSegmentUseCase @Inject constructor(
    private val repository: RecentRepository
) {
    suspend operator fun invoke(cropSegmentTable: CropSegmentTable): Flow<ResultState<String>> {
        return repository.deleteRecentCroppedSegment(cropSegmentTable = cropSegmentTable)
    }
}