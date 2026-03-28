package com.example.audiotrimmer.domain.UseCases.revenueCat

import com.example.audiotrimmer.domain.Repository.RevenueCatRepository
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.revenuecat.purchases.Package

class GetAllPackagesUseCase @Inject constructor(private val revenueCatRepository: RevenueCatRepository) {
    suspend operator fun invoke(): Flow<ResultState<List<Package>>> {
        return revenueCatRepository.getPackages()
    }
}