package com.example.audiotrimmer.presentation.ViewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.audiotrimmer.domain.StateHandeling.RecordAudioState
import com.example.audiotrimmer.domain.StateHandeling.ResultState
import com.example.audiotrimmer.domain.UseCases.RecordAudioUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecordAudioViewModel @Inject constructor(
    private val recordAudioUseCase: RecordAudioUseCase
) : ViewModel() {

    private val _recordAudioState = MutableStateFlow(RecordAudioState())
    val recordAudioState = _recordAudioState.asStateFlow()

    fun startRecording(context: Context, filename: String) {
        viewModelScope.launch(Dispatchers.Main) {
            recordAudioUseCase.startRecording(context = context, filename = filename)
                .collect { result ->
                    when (result) {
                        is ResultState.Loading -> {
                            _recordAudioState.value = RecordAudioState(isLoading = true)
                        }
                        is ResultState.Success -> {
                            _recordAudioState.value = RecordAudioState(
                                isLoading = false,
                                isRecording = true,
                                isPaused = false
                            )
                        }
                        is ResultState.Error -> {
                            _recordAudioState.value = RecordAudioState(
                                isLoading = false,
                                error = result.message
                            )
                        }
                    }
                }
        }
    }

    fun pauseRecording() {
        recordAudioUseCase.pauseRecording()
        _recordAudioState.value = _recordAudioState.value.copy(isPaused = true)
    }

    fun resumeRecording() {
        recordAudioUseCase.resumeRecording()
        _recordAudioState.value = _recordAudioState.value.copy(isPaused = false)
    }

    fun stopRecording(context: Context) {
        viewModelScope.launch(Dispatchers.Main) {
            recordAudioUseCase.stopRecording(context = context).collect { result ->
                when (result) {
                    is ResultState.Loading -> {
                        _recordAudioState.value = RecordAudioState(isLoading = true)
                    }
                    is ResultState.Success -> {
                        _recordAudioState.value = RecordAudioState(
                            isLoading = false,
                            data = result.data,
                            isRecording = false,
                            isPaused = false
                        )
                    }
                    is ResultState.Error -> {
                        _recordAudioState.value = RecordAudioState(
                            isLoading = false,
                            error = result.message,
                            isRecording = false,
                            isPaused = false
                        )
                    }
                }
            }
        }
    }
}