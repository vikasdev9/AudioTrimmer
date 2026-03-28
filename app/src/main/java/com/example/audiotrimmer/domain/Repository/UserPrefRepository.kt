package com.example.audiotrimmer.domain.Repository

import kotlinx.coroutines.flow.Flow

interface UserPrefRepository {
    fun getThemeSelection(): Flow<String>
    suspend fun updateThemeSelection(theme: String)
}