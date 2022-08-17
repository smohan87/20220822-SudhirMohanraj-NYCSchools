package com.example.nyc.schools.domain.model

data class SchoolInformation(
    val name: String,
    val email: String,
    val website: String,
    val zip: String,
    val totalStudents: String,
    val borough: String,
    val graduationRate: String,
    val collegeCareerRate: String
)
