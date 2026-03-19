package com.example.audiotrimmer.domain.Repository

import android.app.Activity
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import com.google.android.gms.ads.AdView
import kotlinx.coroutines.flow.Flow

interface AdsRepository {
    suspend fun loadInterstitialAd(): Flow<ResultState<Boolean>>
    suspend fun showInterstitialAd(activity: Activity): Flow<ResultState<Boolean>>
    fun isAdReady(): Boolean
    fun destroy()

    // Banner Ads
    suspend fun loadBannerAd(adView: AdView): Flow<ResultState<Boolean>>
}