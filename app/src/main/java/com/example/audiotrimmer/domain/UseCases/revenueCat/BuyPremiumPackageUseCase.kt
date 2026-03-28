package com.example.audiotrimmer.domain.UseCases.revenueCat

import android.app.Activity
import com.example.audiotrimmer.domain.Repository.RevenueCatRepository
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import com.revenuecat.purchases.Package
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BuyPremiumPackageUseCase @Inject constructor(
    private val revenueCatRepository: RevenueCatRepository
) {
    suspend operator fun invoke(
        activity: Activity,
        selectedPackage: Package
    ): Flow<ResultState<Boolean>> {
        return revenueCatRepository.buyPremiumPackage(
            activity = activity,
            selectedPackage = selectedPackage
        )
    }
}