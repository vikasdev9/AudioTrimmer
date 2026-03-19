package com.example.audiotrimmer.domain.UseCases

import com.example.audiotrimmer.domain.Repository.AdsRepository
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import com.google.android.gms.ads.AdView
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadBannerAdUseCase @Inject constructor(
    private val adsRepository: AdsRepository
) {
    suspend operator fun invoke(adView: AdView): Flow<ResultState<Boolean>> {
        return adsRepository.loadBannerAd(adView)
    }
}