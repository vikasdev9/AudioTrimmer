package com.example.audiotrimmer.domain.UseCases.userPref

import com.example.audiotrimmer.domain.Repository.UserPrefRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserPrefUseCase @Inject constructor(
    private val repository: UserPrefRepository
) {
    fun getThemeSelection(): Flow<String> {
        return repository.getThemeSelection()
    }

    suspend fun updateThemeSelection(theme: String) {
        repository.updateThemeSelection(theme = theme)
    }
}