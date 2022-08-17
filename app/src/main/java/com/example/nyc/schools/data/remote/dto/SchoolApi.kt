package com.example.nyc.schools.data.remote.dto

import com.example.nyc.schools.domain.model.SchoolDetail
import retrofit2.http.GET

interface SchoolApi {

    @GET("resource/s3k6-pzi2.json")
    suspend fun getSchools(): List<SchoolItem>

    @GET("resource/f9bf-2cp4.json")
    suspend fun getSchoolDetail(): List<SchoolDetail>

    companion object {
        const val BASE_URL = "https://data.cityofnewyork.us/"
    }
}