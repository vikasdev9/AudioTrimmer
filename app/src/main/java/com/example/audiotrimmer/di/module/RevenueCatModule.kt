package com.example.audiotrimmer.di.module


import com.example.audiotrimmer.data.RepoImpl.RevenueCatRepoImpl
import com.example.audiotrimmer.domain.Repository.RevenueCatRepository
import com.example.audiotrimmer.domain.UseCases.revenueCat.BuyPremiumPackageUseCase
import com.example.audiotrimmer.domain.UseCases.revenueCat.GetAllPackagesUseCase
import com.example.audiotrimmer.domain.UseCases.revenueCat.IsUserProUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object RevenueCatModule {
    @Provides
    fun provideRevenueCatRepo(): RevenueCatRepository {
        return RevenueCatRepoImpl()
    }

    @Provides
    fun provideGetPackageUseCase(revenueCatRepository: RevenueCatRepository): GetAllPackagesUseCase {
        return GetAllPackagesUseCase(revenueCatRepository = revenueCatRepository)
    }

    @Provides
    fun provideIsUserProUseCase(revenueCatRepository: RevenueCatRepository): IsUserProUseCase {
        return IsUserProUseCase(revenueCatRepository = revenueCatRepository)
    }

    @Provides
    fun provideBuyPremiumPackageUseCase(revenueCatRepository: RevenueCatRepository): BuyPremiumPackageUseCase {
        return BuyPremiumPackageUseCase(revenueCatRepository = revenueCatRepository)
    }
}