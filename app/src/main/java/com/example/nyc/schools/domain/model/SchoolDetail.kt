package com.example.nyc.schools.domain.model

import com.google.gson.annotations.SerializedName

data class SchoolDetail(
    val dbn: String?,
    val numOfSatTestTakers: String?,
    val satCriticalReadingAvgScore: String?,
    val satMathAvgScore: String?,
    val satWritingAvgScore: String?,
    val schoolName: String?
)
