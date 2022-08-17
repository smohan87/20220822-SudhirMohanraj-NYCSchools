package com.example.nyc.schools.presentation.overview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nyc.schools.domain.model.SchoolListState
import com.example.nyc.schools.domain.repository.SchoolRepository
import com.example.nyc.schools.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolListViewModel @Inject constructor(
    private val repository: SchoolRepository
) : ViewModel() {

    var state by mutableStateOf(SchoolListState())

    private var searchJob: Job? = null

    init {
        getSchoolList()
    }

    fun onEvent(event: SchoolListEvent) {
        when (event) {
            is SchoolListEvent.Refresh -> {
                getSchoolList(fetchFromRemote = true)
            }
            is SchoolListEvent.OnSearchQueryChange -> {
                state = state.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500L)
                    getSchoolList()
                }
            }
        }
    }

    private fun getSchoolList(
        query: String = state.searchQuery.lowercase(),
        fetchFromRemote: Boolean = false
    ) {
        viewModelScope.launch {
            repository
                .getSchools(fetchFromRemote, query)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let { listOfSchools ->
                                state = state.copy(
                                    schools = listOfSchools
                                )
                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }
}