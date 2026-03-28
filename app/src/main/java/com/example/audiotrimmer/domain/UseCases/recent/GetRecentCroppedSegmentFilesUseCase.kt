package com.example.audiotrimmer.domain.UseCases.recent

import com.example.audiotrimmer.domain.Repository.RecentRepository
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecentCroppedSegmentFilesUseCase @Inject constructor(
    private val repository: RecentRepository
) {
    suspend operator fun invoke(): Flow<ResultState<List<String>>> {
        return repository.getRecentCroppedSegmentFiles()
    }
}