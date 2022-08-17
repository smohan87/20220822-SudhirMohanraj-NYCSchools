package com.example.nyc.schools.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nyc.schools.domain.model.SchoolDetail
import com.example.nyc.schools.domain.model.SchoolDetailState
import com.example.nyc.schools.domain.repository.SchoolRepository
import com.example.nyc.schools.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: SchoolRepository) : ViewModel() {
    var state by mutableStateOf(SchoolDetailState())

    init {
        viewModelScope.launch {
            val dbn = savedStateHandle.get<String>("symbol") ?: return@launch
            state = state.copy(isLoading = true)
            val schoolDetailResult = async { repository.getSchoolDetails(dbn) }
            when (val result = schoolDetailResult.await()) {
                is Resource.Success<*> -> {
                    state = state.copy(
                        schoolDetail = result.data,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error<*> -> {
                    state = state.copy(
                        isLoading = false,
                        error = result.message,
                        schoolDetail = null
                    )
                }
                else -> Unit
            }
        }
    }
}