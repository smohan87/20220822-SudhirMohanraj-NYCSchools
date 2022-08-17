package com.example.nyc.schools.domain.model

data class SchoolDetailState(
    val schoolDetail: SchoolDetail? = null,
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val error: String? = null
)
