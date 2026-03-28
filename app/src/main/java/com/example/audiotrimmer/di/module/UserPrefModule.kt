package com.example.audiotrimmer.di.module

import android.content.Context
import com.example.audiotrimmer.data.RepoImpl.UserPrefRepositoryImpl
import com.example.audiotrimmer.data.userPref.UserPrefrenceStore
import com.example.audiotrimmer.domain.Repository.UserPrefRepository
import com.example.audiotrimmer.domain.UseCases.userPref.UserPrefUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UserPrefModule {
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context{
        return context
    }
    @Provides
    fun provideUserPrefStore(@ApplicationContext context: Context): UserPrefrenceStore {
        return UserPrefrenceStore(context= context)
    }

    @Provides
    fun provideUserPrefRepository(userPrefrenceStore: UserPrefrenceStore): UserPrefRepository {
        return UserPrefRepositoryImpl(userPrefrenceStore = userPrefrenceStore)
    }

    @Provides
    fun provideUserPrefUseCase(userPrefRepository: UserPrefRepository): UserPrefUseCase {
        return UserPrefUseCase(repository = userPrefRepository)
    }
}