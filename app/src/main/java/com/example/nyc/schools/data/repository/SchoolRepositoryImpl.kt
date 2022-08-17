package com.example.nyc.schools.data.repository

import android.util.Log
import com.example.nyc.schools.data.local.SchoolDatabase
import com.example.nyc.schools.data.mapper.toSchoolInformation
import com.example.nyc.schools.data.mapper.toSchoolInformationEntity
import com.example.nyc.schools.data.remote.dto.SchoolApi
import com.example.nyc.schools.data.remote.dto.toSchoolInformation
import com.example.nyc.schools.domain.model.SchoolDetail
import com.example.nyc.schools.domain.model.SchoolInformation
import com.example.nyc.schools.domain.repository.SchoolRepository
import com.example.nyc.schools.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SchoolRepositoryImpl @Inject constructor(
    val api: SchoolApi,
    val db: SchoolDatabase
) : SchoolRepository {
    private val dao = db.dao

    override suspend fun getSchools(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<SchoolInformation>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))

            val localInformation = dao.searchSchoolInformation(query)
            emit(
                Resource.Success(
                data = localInformation.map { it.toSchoolInformation() }
            ))

            val isDbEmpty = localInformation.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteSchoolInformation = try {
                var temp = api.getSchools()
                temp.map { it.toSchoolInformation() }
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Data could not be loaded"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Data could not be loaded"))
                null
            }

            remoteSchoolInformation?.let { schoolInformation ->
                dao.clearSchoolInformation()
                dao.insertSchoolInformation(
                    schoolInformation.map { it.toSchoolInformationEntity() }
                )
                emit(
                    Resource.Success(
                        data = dao.searchSchoolInformation("").map { it.toSchoolInformation() })
                )
                // Something is going on here.
                // emit(Resource.Loading(isLoading = false))
            }
        }
    }

//    override suspend fun getSchoolDetails(
//        fetchFromRemote: Boolean,
//        query: String
//    ): Flow<Resource<List<SchoolDetail>>> {
//        return try {
//
//        } catch (e: IOException) {
//            e.printStackTrace()
//            emit(Resource.Error("Data could not be loaded for School Details"))
//            null
//        } catch (e: HttpException) {
//            e.printStackTrace()
//            emit(Resource.Error("Data could not be loaded for School Details"))
//            null
//        }
//    }
}