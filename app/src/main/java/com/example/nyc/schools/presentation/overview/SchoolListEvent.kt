package com.example.nyc.schools.presentation.overview

sealed class SchoolListEvent {
    object Refresh: SchoolListEvent()
    data class OnSearchQueryChange(val query:String): SchoolListEvent()
}