package com.example.audiotrimmer.data.RepoImpl


import com.example.audiotrimmer.data.userPref.UserPrefrenceStore
import com.example.audiotrimmer.domain.Repository.UserPrefRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserPrefRepositoryImpl @Inject constructor(
    private val userPrefrenceStore: UserPrefrenceStore
) : UserPrefRepository {

    override fun getThemeSelection(): Flow<String> {
        return userPrefrenceStore.themeSelection
    }

    override suspend fun updateThemeSelection(theme: String) {
        userPrefrenceStore.updateThemeSelection(theme = theme)
    }
}