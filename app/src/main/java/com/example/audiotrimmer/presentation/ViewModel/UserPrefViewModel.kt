package com.example.audiotrimmer.presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.audiotrimmer.Constant.Colors
import com.example.audiotrimmer.domain.UseCases.userPref.UserPrefUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserPrefViewModel @Inject constructor(
    private val userPrefUseCase: UserPrefUseCase
) : ViewModel() {

    private val _themeSelection = MutableStateFlow(Colors.ORANGETHEME)
    val themeSelection = _themeSelection.asStateFlow()

    init {
        observeThemeSelection()
    }

    private fun observeThemeSelection() {
        viewModelScope.launch(Dispatchers.IO) {
            userPrefUseCase.getThemeSelection().collect { currentTheme ->
                _themeSelection.value = currentTheme
            }
        }
    }

    fun updateThemeSelection(theme: String) {
        _themeSelection.value = theme
        viewModelScope.launch(Dispatchers.IO) {
            userPrefUseCase.updateThemeSelection(theme = theme)
        }
    }
}