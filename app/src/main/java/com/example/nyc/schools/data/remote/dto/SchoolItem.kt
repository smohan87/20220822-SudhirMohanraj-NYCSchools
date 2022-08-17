package com.example.nyc.schools.data.remote.dto

import com.example.nyc.schools.domain.model.SchoolInformation
import com.google.gson.annotations.SerializedName

data class SchoolItem(
    @SerializedName("academicopportunities1")
    val academicopportunities1: String?,
    @SerializedName("academicopportunities2")
    val academicopportunities2: String?,
    @SerializedName("academicopportunities3")
    val academicopportunities3: String?,
    @SerializedName("academicopportunities4")
    val academicopportunities4: String?,
    @SerializedName("admissionspriority11")
    val admissionspriority11: String?,
    @SerializedName("admissionspriority21")
    val admissionspriority21: String?,
    @SerializedName("advancedplacement_courses")
    val advancedplacementCourses: String?,
    @SerializedName("attendance_rate")
    val attendanceRate: String?,
    @SerializedName("bbl")
    val bbl: String?,
    @SerializedName("bin")
    val bin: String?,
    @SerializedName("boro")
    val boro: String?,
    @SerializedName("borough")
    val borough: String?,
    @SerializedName("building_code")
    val buildingCode: String?,
    @SerializedName("bus")
    val bus: String?,
    @SerializedName("campus_name")
    val campusName: String?,
    @SerializedName("census_tract")
    val censusTract: String?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("code1")
    val code1: String?,
    @SerializedName("college_career_rate")
    val collegeCareerRate: String?,
    @SerializedName("community_board")
    val communityBoard: String?,
    @SerializedName("council_district")
    val councilDistrict: String?,
    @SerializedName("dbn")
    val dbn: String?,
    @SerializedName("ell_programs")
    val ellPrograms: String?,
    @SerializedName("end_time")
    val endTime: String?,
    @SerializedName("extracurricular_activities")
    val extracurricularActivities: String?,
    @SerializedName("fax_number")
    val faxNumber: String?,
    @SerializedName("finalgrades")
    val finalgrades: String?,
    @SerializedName("grade9geapplicants1")
    val grade9geapplicants1: String?,
    @SerializedName("grade9geapplicantsperseat1")
    val grade9geapplicantsperseat1: String?,
    @SerializedName("grade9gefilledflag1")
    val grade9gefilledflag1: String?,
    @SerializedName("grade9swdapplicants1")
    val grade9swdapplicants1: String?,
    @SerializedName("grade9swdapplicantsperseat1")
    val grade9swdapplicantsperseat1: String?,
    @SerializedName("grade9swdfilledflag1")
    val grade9swdfilledflag1: String?,
    @SerializedName("grades2018")
    val grades2018: String?,
    @SerializedName("graduation_rate")
    val graduationRate: String?,
    @SerializedName("interest1")
    val interest1: String?,
    @SerializedName("language_classes")
    val languageClasses: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("longitude")
    val longitude: String?,
    @SerializedName("method1")
    val method1: String?,
    @SerializedName("neighborhood")
    val neighborhood: String?,
    @SerializedName("nta")
    val nta: String?,
    @SerializedName("offer_rate1")
    val offerRate1: String?,
    @SerializedName("overview_paragraph")
    val overviewParagraph: String?,
    @SerializedName("pct_stu_enough_variety")
    val pctStuEnoughVariety: String?,
    @SerializedName("pct_stu_safe")
    val pctStuSafe: String?,
    @SerializedName("phone_number")
    val phoneNumber: String?,
    @SerializedName("prgdesc1")
    val prgdesc1: String?,
    @SerializedName("primary_address_line_1")
    val primaryAddressLine1: String?,
    @SerializedName("program1")
    val program1: String?,
    @SerializedName("psal_sports_boys")
    val psalSportsBoys: String?,
    @SerializedName("psal_sports_coed")
    val psalSportsCoed: String?,
    @SerializedName("psal_sports_girls")
    val psalSportsGirls: String?,
    @SerializedName("school_10th_seats")
    val school10thSeats: String?,
    @SerializedName("school_accessibility_description")
    val schoolAccessibilityDescription: String?,
    @SerializedName("school_email")
    val schoolEmail: String?,
    @SerializedName("school_name")
    val schoolName: String?,
    @SerializedName("seats101")
    val seats101: String?,
    @SerializedName("seats9ge1")
    val seats9ge1: String?,
    @SerializedName("seats9swd1")
    val seats9swd1: String?,
    @SerializedName("shared_space")
    val sharedSpace: String?,
    @SerializedName("start_time")
    val startTime: String?,
    @SerializedName("state_code")
    val stateCode: String?,
    @SerializedName("subway")
    val subway: String?,
    @SerializedName("total_students")
    val totalStudents: String?,
    @SerializedName("website")
    val website: String?,
    @SerializedName("zip")
    val zip: String?
)

fun SchoolItem.toSchoolInformation(): SchoolInformation {
    return SchoolInformation(
        name = schoolName ?: "",
        email = schoolEmail ?: "",
        website = website ?: "",
        zip = zip ?: "",
        totalStudents = totalStudents ?: "",
        borough = borough ?: "",
        graduationRate = graduationRate ?: "",
        collegeCareerRate = collegeCareerRate ?: "",
        dbn = dbn ?: ""
    )
}