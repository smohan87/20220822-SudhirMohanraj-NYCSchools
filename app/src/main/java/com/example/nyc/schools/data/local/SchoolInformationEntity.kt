package com.example.nyc.schools.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SchoolInformationEntity(
    val name:String,
    val email:String,
    val website:String,
    val zip:String,
    val totalStudents:String,
    val borough: String,
    val graduationRate: String,
    val collegeCareerRate: String,
    @PrimaryKey val id:Int? = null
)
