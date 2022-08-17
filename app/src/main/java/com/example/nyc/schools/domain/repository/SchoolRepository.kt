package com.example.nyc.schools.domain.repository

import com.example.nyc.schools.domain.model.SchoolDetail
import com.example.nyc.schools.domain.model.SchoolInformation
import com.example.nyc.schools.util.Resource
import kotlinx.coroutines.flow.Flow

interface SchoolRepository {
    suspend fun getSchools(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<SchoolInformation>>>

//    suspend fun getSchoolDetails(
//        fetchFromRemote: Boolean,
//        query: String
//    ): Flow<Resource<List<SchoolDetail>>>
}