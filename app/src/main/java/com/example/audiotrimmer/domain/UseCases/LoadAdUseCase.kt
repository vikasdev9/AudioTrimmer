package com.example.audiotrimmer.domain.UseCases


import com.example.audiotrimmer.domain.Repository.AdsRepository
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadAdUseCase @Inject constructor(
    private val repository: AdsRepository
) {
    suspend operator fun invoke(): Flow<ResultState<Boolean>> {
        return repository.loadInterstitialAd()
    }
}