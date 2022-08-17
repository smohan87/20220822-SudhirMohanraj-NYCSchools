package com.example.nyc.schools.domain.model

import com.example.nyc.schools.domain.model.SchoolInformation

data class SchoolListState(
    val schools: List<SchoolInformation> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)