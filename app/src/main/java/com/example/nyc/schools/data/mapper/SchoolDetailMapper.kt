package com.example.nyc.schools.data.mapper

import com.example.nyc.schools.data.remote.dto.SchoolDetailDto
import com.example.nyc.schools.domain.model.SchoolDetail

fun SchoolDetailDto.toSchoolDetail(): SchoolDetail {
    return SchoolDetail(
        dbn = dbn,
        numOfSatTestTakers = numOfSatTestTakers,
        satCriticalReadingAvgScore = satCriticalReadingAvgScore,
        satMathAvgScore = satMathAvgScore,
        satWritingAvgScore = satWritingAvgScore,
        schoolName = schoolName
    )
}