package com.example.audiotrimmer.domain.UseCases

import com.example.audiotrimmer.data.DataClass.Song
import com.example.audiotrimmer.domain.Repository.GetAllSongRepository
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject



class GetAllSongUseCase @Inject constructor(private val getAllSongRepository: GetAllSongRepository) {
    suspend operator fun invoke(): Flow<ResultState<List<Song>>>{
        return getAllSongRepository.getAllSongs()
    }
}