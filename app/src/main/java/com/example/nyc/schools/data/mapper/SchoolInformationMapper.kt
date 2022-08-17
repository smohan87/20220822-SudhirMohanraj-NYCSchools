package com.example.nyc.schools.data.mapper

import com.example.nyc.schools.data.local.SchoolInformationEntity
import com.example.nyc.schools.domain.model.SchoolInformation

fun SchoolInformationEntity.toSchoolInformation(): SchoolInformation {
    return SchoolInformation(
        name = name,
        email = email,
        website = website,
        zip = zip,
        totalStudents = totalStudents,
        borough = borough,
        collegeCareerRate = collegeCareerRate,
        graduationRate = graduationRate,
        dbn = dbn

    )
}

fun SchoolInformation.toSchoolInformationEntity(): SchoolInformationEntity {
    return SchoolInformationEntity(
        name = name,
        email = email,
        website = website,
        zip = zip,
        totalStudents = totalStudents,
        borough = borough,
        collegeCareerRate = collegeCareerRate,
        graduationRate = graduationRate,
        dbn = dbn
    )
}