package com.example.nyc.schools.data.remote.dto

import com.example.nyc.schools.domain.model.SchoolDetail
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolApi {

    @GET("resource/s3k6-pzi2.json")
    suspend fun getSchools(): List<SchoolItem>

    @GET("resource/f9bf-2cp4.json")
    suspend fun getSchoolDetail(@Query("dbn")dbn:String): List<SchoolDetailDto>

    companion object {
        const val BASE_URL = "https://data.cityofnewyork.us/"
    }
}